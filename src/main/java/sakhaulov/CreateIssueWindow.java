package sakhaulov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateIssueWindow extends AbstractPage {

    @FindBy(id = "issue-create.ui.modal.create-form.type-picker.issue-type-select")
    private WebElement issueTypeSelect;

    @FindBy(xpath = ".//div[@id='issue-create.ui.modal.create-form.type-picker.issue-type-select']/*/div[contains(.,'Bug')]")
    private WebElement issueTypeBug;

    @FindBy(id = "summary-field")
    private WebElement summary;

    @FindBy(xpath = ".//button[@data-testid='issue-create.common.ui.footer.create-button']")
    private WebElement create;

    public CreateIssueWindow(WebDriver driver) {
        super(driver);
    }

    public CreateIssueWindow clickIssueType() {
        issueTypeSelect.click();
        return this;
    }

    public CreateIssueWindow clickIssueTypeBug() {
        issueTypeBug.click();
        return this;
    }

    public CreateIssueWindow clickSummary() {
        summary.click();
        return this;
    }

    public CreateIssueWindow sendKeysSummary(String input) {
        summary.sendKeys(input);
        return this;
    }

    public CreateIssueWindow clickCreate() {
        create.click();
        return this;
    }

}
