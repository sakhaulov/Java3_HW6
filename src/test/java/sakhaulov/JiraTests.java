package sakhaulov;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class JiraTests extends AbstractTest {

    @BeforeAll
    static void authorize() {

        getDriver().navigate().to("https://id.atlassian.com/login");
        new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("id.atlassian.com/login"));

        LogInPage logInPage = new LogInPage(getDriver());

        logInPage
                .clickUsername()
                .enterUsername(TestData.LOGIN)
                .clickSubmit()
                .clickPassword()
                .enterPassword(TestData.PASSWORD)
                .clickSubmit();

        //Home page | Authorization assertion
        new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("start.atlassian.com"));
        Assertions.assertTrue(getDriver().findElements(By.xpath(".//*[contains(text(), 'sakhaulov')]")).size() > 0,
                              "Ошибка авторизации");
    }


    @Test
    @DisplayName("Переход на доску проекта")
    void visitProjectBoard() {

        getDriver().navigate().to("https://start.atlassian.com/");

        new HomePage(getDriver()).clickTsakhaulovJiraSoftware();
        new ProjectsPage(getDriver()).clickSakhaulovProject();

        //Project board page | Content assertion
        List<WebElement> webElements = getDriver().findElements(By.xpath(".//h1[contains(text(), 'SAKH board')]"));
        Assertions.assertTrue(webElements.size() > 0);
    }


    @Test
    @DisplayName("Создание баг-репорта")
    void createBugTest() {

        String bugName = "MyTestBugAutomated" + (int)(Math.random() * (1000 - 1)) + 1;

        getDriver().navigate().to("https://tsakhaulov.atlassian.net/jira/software/projects/SAKH/boards/1");

        //Project board page
        new WebDriverWait(getDriver(), Duration.ofSeconds(7))
                .until(ExpectedConditions.elementToBeClickable(By.id("createGlobalItem")));

        new ProjectHeader(getDriver()).clickCreate();

        //Create issue modal window
        new WebDriverWait(getDriver(), Duration.ofSeconds(7))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("summary-field")));
        CreateIssueWindow createIssueWindow = new CreateIssueWindow(getDriver());
        createIssueWindow
                .clickIssueType()
                .clickIssueTypeBug()
                .clickSummary()
                .sendKeysSummary(bugName)
                .clickCreate();

        //Assertions
        //Check fo pop-up
        Assertions.assertEquals(1, getDriver().findElements(By.cssSelector(".css-1do2z69")).size(),
                "Не обнаружено всплывающее окно с сообщением о создании баг-репорта");
        //Check if element present on "backlog" page
        new ProjectBoardPage(getDriver()).clickBacklog();
        new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(text(), 'MyTestBugAutomated')]")));
        Assertions.assertTrue(getDriver().findElements(By.xpath(String.format(".//div[contains(text(), '%s')]", bugName))).size() > 0,
                "Созданный баг не обнаружен в бэклоге");

    }


    @Test
    @DisplayName("Создание команды")
    void startTeamTest() {

        String teamName = "MyTestTeamAutomated" + (int)(Math.random() * (1000 - 1)) + 1;

        getDriver().navigate().to("https://tsakhaulov.atlassian.net/jira/software/projects/SAKH/boards/1");
        new WebDriverWait(getDriver(), Duration.ofSeconds(7))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[@data-testid='menu-people-primary-button']")));

        //Products page
        ProjectHeader projectHeader = new ProjectHeader(getDriver());
        projectHeader
                .clickPeople()
                .clickSearchPeopleAndTeams();

        //Team management page
        new PeoplePage(getDriver()).clickStartATeam();

        //Start a team modal window
        StartANewTeamWindow startANewTeamWindow = new StartANewTeamWindow(getDriver());
        startANewTeamWindow
                .sendKeysTeamName(teamName)
                .clickStartTeam();

        //Close "get started" modal window
        getDriver().switchTo().activeElement();
        getDriver().findElement(By.cssSelector(".css-eubphy")).click();

        //Assertions
        Assertions.assertTrue(getDriver()
                .findElements(By.xpath(String.format("//*[contains(text(), '%s')]", teamName))).size() > 0,
                "Созданная команда не обнаружена");

    }


    @Test
    @DisplayName("Создание собственного типа документа")
    void addingStandartIssueTypeTest() throws InterruptedException {

        String testIssueTypeName = "TestIssueType" + (int) (Math.random() * (1000 - 1)) + 1;

        getDriver().navigate().to("https://tsakhaulov.atlassian.net/jira/software/projects/SAKH/boards/1");
        new WebDriverWait(getDriver(), Duration.ofSeconds(7))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@aria-label='Settings']")));

        //Settings menu
        ProjectHeader projectHeader = new ProjectHeader(getDriver());
        projectHeader
                .clickSettingsIcon()
                .clickSettingsIssues();

        //Issue types page
        IssueTypesPage  issueTypesPage = new IssueTypesPage(getDriver());
        issueTypesPage.clickAddIssueType();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3));

        //Add issue type modal window
        AddIssueTypeWindow addIssueTypeWindow = new AddIssueTypeWindow(getDriver());
        addIssueTypeWindow
                .sendKeysName(testIssueTypeName)
                .clickStandartIssueType()
                .clickAdd();

        //Assertions
        Assertions.assertTrue(getDriver()
                .findElements(By.xpath(String.format(".//strong[contains(.,'%s')]", testIssueTypeName))).size() > 0);

    }
}

