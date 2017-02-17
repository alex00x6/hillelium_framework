package models.linkedinmobile;

import base.mobile.AndroidSetup;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Storm on 20.12.2016.
 */
public class BasePage extends AndroidSetup {

    protected WebDriver driver;

    public BasePage(WebDriver driver){

        this.driver = driver;
    }

    //This is the peace of every locator on the app page
    String app_package_name = "com.linkedin.android:id/";

    //Method that waits for visiability of UI element
    protected void waitForVisibilityOf(By locator) {

        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void swipeFromRightToLeft(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        TouchAction action = new TouchAction((AppiumDriver) driver);
        action.press(720, 570).moveTo(-400, 0).release().perform();

    }

    public void scrollPageDown() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        TouchAction action = new TouchAction((AppiumDriver) driver);
        action.press(350, 900).moveTo(0, -400).release().perform();
    }

//    public void tap() {
//
//        ((AppiumDriver) driver).tap(1, driver.findElement(By.id(app_package_name + "")), 1000);
//    }
}

