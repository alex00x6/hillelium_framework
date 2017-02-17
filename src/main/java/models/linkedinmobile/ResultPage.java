package models.linkedinmobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Storm on 20.12.2016.
 */
public class ResultPage extends BasePage{

    public ResultPage(WebDriver driver){

        super(driver);
    }

    By messageButton = By.id(app_package_name + "profile_view_top_card_primary_button");

    public MessagePage clickOnMessageButton(){

        waitForVisibilityOf(messageButton);

        driver.findElement(messageButton).click();

        return new MessagePage(driver);
    }

}
