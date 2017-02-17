package models.linkedinmobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Storm on 20.12.2016.
 */
public class MessagePage extends HomePage {

    public MessagePage(WebDriver driver) {

        super(driver);

    }

    By messageInput = By.id(app_package_name + "msglib_keyboard_text_input_container");
    By messageSend = By.id(app_package_name + "msglib_keyboard_send_button");
    By messageContainer = By.id(app_package_name + "msglib_message_list_item_container");
    By bubbleMessage = By.id(app_package_name + "body");

    String message = "Hello from Appium!";

    public MessagePage createMessage(){

        waitForVisibilityOf(messageInput);

        driver.findElement(messageInput).sendKeys(message);

        driver.findElement(messageSend).click();

        return new MessagePage(driver);

    }

    public boolean checkForSending(){

        waitForVisibilityOf(messageContainer);

        driver.findElement(bubbleMessage).getText().contains(message);

        return true;
    }

}
