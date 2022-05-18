package sakhaulov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectHeader extends AbstractPage {

    @FindBy(xpath = ".//button[@id='createGlobalItem']")
    private WebElement create;

    @FindBy(xpath = ".//button[@data-testid='menu-people-primary-button']")
    private WebElement people;

    @FindBy(xpath = ".//a[@data-testid='menu-view-people-directory']")
    private WebElement searchPeopleAndTeams;

    @FindBy(xpath = ".//*[@aria-label='Settings']")
    private WebElement settingsIcon;

    @FindBy(partialLinkText = "Issues")
    private WebElement settingsIssues;


    public ProjectHeader(WebDriver driver) {
        super(driver);
    }

    public ProjectHeader clickCreate() {
        create.click();
        return this;
    }

    public ProjectHeader clickPeople() {
        people.click();
        return this;
    }

    public ProjectHeader clickSearchPeopleAndTeams() {
        searchPeopleAndTeams.click();
        return this;
    }

    public ProjectHeader clickSettingsIcon() {
        settingsIcon.click();
        return this;
    }

    public ProjectHeader clickSettingsIssues() {
        settingsIssues.click();
        return this;
    }
}
