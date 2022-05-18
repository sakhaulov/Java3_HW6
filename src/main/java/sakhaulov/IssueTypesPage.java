package sakhaulov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssueTypesPage extends AbstractPage {

    @FindBy(xpath = ".//button[@data-testid='admin-pages-issue-types-directory.ui.header-actions.add-issue-type-button']")
    private WebElement addIssueType;

    public IssueTypesPage(WebDriver driver) {
        super(driver);
    }

    public IssueTypesPage clickAddIssueType() {
        addIssueType.click();
        return this;
    }

}
