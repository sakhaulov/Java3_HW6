package sakhaulov;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizationTests extends AbstractTest{

    @Test
    void authWrongPassTest() {

        getDriver().navigate().to("https://www.atlassian.com/");

        IndexPage indexPage = new IndexPage(getDriver());

        indexPage
                .clickMyAccount()
                .clickLogIn();

        new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("id.atlassian.com/login"));

        LogInPage logInPage = new LogInPage(getDriver());

        logInPage
                .clickUsername()
                .enterUsername(TestData.LOGIN)
                .clickSubmit()
                .clickPassword()
                .enterPassword(TestData.WRONG_PASSWORD)
                .clickSubmit();

        //No authorization assertion
        new WebDriverWait(getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(".//*[@id='login-error']/span[contains(text(), 'Неверный адрес электронной почты и/или пароль.')]")));

        Assertions.assertNotEquals("https://start.atlassian.com/", getDriver().getCurrentUrl());
        Assertions.assertTrue(getDriver().findElements(
                By.xpath(".//*[@id='login-error']/span[contains(text(), 'Неверный адрес электронной почты и/или пароль.')]")).size() > 0);
    }


}
