package sakhaulov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    private WebDriver driver;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected AbstractPage pause(Long duration, AbstractPage page) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            System.out.println("Sleep has been interrupted");
        }
        return page;
    }

    protected WebDriver getDriver(){
        return this.driver;
    }
}
