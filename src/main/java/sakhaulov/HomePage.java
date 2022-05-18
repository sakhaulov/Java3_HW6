package sakhaulov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[contains(text(), 'tsakhaulov')]")
    private WebElement tsakhaulovJiraSoftware;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickTsakhaulovJiraSoftware() {
        tsakhaulovJiraSoftware.click();
        return this;
    }

}
