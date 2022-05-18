package sakhaulov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PeoplePage extends AbstractPage {

    private WebElement startATeam;

    public PeoplePage(WebDriver driver) {
        super(driver);
    }

    public PeoplePage clickStartATeam() {
        getDriver().findElements(By.xpath(".//div[@data-test-selector='create-team-button']")).get(0).click();
        return this;
    }
}
