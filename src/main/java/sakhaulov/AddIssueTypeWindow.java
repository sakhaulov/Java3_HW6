package sakhaulov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddIssueTypeWindow extends AbstractPage {

    @FindBy(name = "name")
    private WebElement name;

    @FindBy(xpath = ".//span[contains(text(), 'Standard Issue Type')]")
    private WebElement standartIssueType;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement add;

    public AddIssueTypeWindow(WebDriver driver) {
        super(driver);
    }

    public AddIssueTypeWindow sendKeysName (String input) {
        name.sendKeys(input);
        return this;
    }

    public AddIssueTypeWindow clickStandartIssueType() {
        standartIssueType.click();
        return this;
    }

    public AddIssueTypeWindow clickAdd() {
        add.click();
        return this;
    }

}
