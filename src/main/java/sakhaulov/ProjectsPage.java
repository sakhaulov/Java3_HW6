package sakhaulov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends AbstractPage {

    @FindBy(xpath = "//a[@href='/browse/SAKH']")
    private WebElement sakhaulovProject;

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage clickSakhaulovProject() {
        sakhaulovProject.click();
        return this;
    }

}
