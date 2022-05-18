package sakhaulov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends AbstractPage {

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "login-submit")
    private WebElement submit;

    @FindBy(id = "password")
    private WebElement password;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public LogInPage clickUsername() {
        username.click();
        return this;
    }

    public LogInPage enterUsername(String input) {
        username.sendKeys(input);
        return this;
    }

    public LogInPage clickPassword() {
        password.click();
        return this;
    }

    public LogInPage enterPassword(String input) {
        password.sendKeys(input);
        return this;
    }

    public LogInPage clickSubmit() {
        submit.click();
        return this;
    }

}
