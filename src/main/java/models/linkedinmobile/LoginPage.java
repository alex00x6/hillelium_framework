package models.linkedinmobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Storm on 20.12.2016.
 */
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Login Page locators

    By firstSignIn = By.id(app_package_name + "growth_prereg_fragment_sign_in_button");
    By userEmail = By.id(app_package_name + "growth_login_join_fragment_email_address");
    By userPassword = By.id(app_package_name + "growth_login_join_fragment_password");
    By loginButton = By.id(app_package_name + "growth_login_fragment_sign_in");
    By homeButton = By.id(app_package_name + "home_nav_tab_icon");
    String myEmail = "alex00x6@gmail.com";
    String myPassword = "parol101";

    public HomePage loginIntoProfile() {

        waitForVisibilityOf(firstSignIn);

        driver.findElement(firstSignIn).click();

        driver.findElement(userEmail).sendKeys(myEmail);
        driver.findElement(userPassword).sendKeys(myPassword);

        driver.findElement(loginButton).click();

        waitForVisibilityOf(homeButton);

        return new HomePage(driver);
    }

}

