package sakhaulov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//Not used ATM

public class YourWorkPage extends AbstractPage {

    @FindBy(xpath = "//a[@href='https://tsakhaulov.atlassian.net/browse/SAKH']")
    private WebElement projectSakhaulov;

    public YourWorkPage(WebDriver driver) {
        super(driver);
    }

    public YourWorkPage clickProjectSakhaulov() {
        projectSakhaulov.click();
        return this;
    }

}
