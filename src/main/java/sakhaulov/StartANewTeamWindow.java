package sakhaulov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartANewTeamWindow extends AbstractPage{

    @FindBy(name = "teamName")
    private WebElement teamName;

    @FindBy(xpath = ".//span[contains(text(), 'Start team')]")
    private WebElement startTeam;

    public StartANewTeamWindow(WebDriver driver) {
        super(driver);
    }


    public StartANewTeamWindow sendKeysTeamName(String input) {
        teamName.sendKeys(input);
        return this;
    }

    public StartANewTeamWindow clickStartTeam() {
        startTeam.click();
        return this;
    }

}
