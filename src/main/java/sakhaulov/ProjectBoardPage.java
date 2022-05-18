package sakhaulov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectBoardPage extends AbstractPage {


    @FindBy(xpath = ".//a[@data-testid='navigation-apps-sidebar-next-gen.ui.menu.software-backlog-link']")
    private WebElement backlog;

    public ProjectBoardPage(WebDriver driver) {
        super(driver);
    }


    public ProjectBoardPage clickBacklog() {
        backlog.click();
        return this;
    }
}
