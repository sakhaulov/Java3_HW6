package sakhaulov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends AbstractPage{

    @FindBy(id = "imkt-jsx--3642d018")
    private WebElement myAccount;

    @FindBy(xpath = ".//span[contains(text(), 'Log in')]")
    private WebElement logIn;

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public IndexPage clickMyAccount(){
        myAccount.click();
        return this;
    }

    public IndexPage clickLogIn(){
        logIn.click();
        return this;
    }

}
