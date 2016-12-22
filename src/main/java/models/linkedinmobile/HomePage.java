package models.linkedinmobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Storm on 20.12.2016.
 */
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {

        super(driver);
    }

    By searchBar = By.id(app_package_name + "search_bar_text");
    By feedContainer = By.id(app_package_name + "feed_item_single_update_container");
    By slideUpInfoItem = By.id(app_package_name + "home_app_launcher_item_title");

    public ResultListPage searchFor(String keyword) {

        waitForVisibilityOf(searchBar);

        driver.findElement(searchBar).sendKeys(keyword);

        return new ResultListPage(driver);

    }

    public void swipeFromRightToPullMenu() {

        waitForVisibilityOf(feedContainer);

        new HomePage(driver).swipeFromRightToLeft();

        waitForVisibilityOf(slideUpInfoItem);

    }

    public void scrollUponHomePage() {

        waitForVisibilityOf(feedContainer);

        new HomePage(driver).scrollPageDown();

    }
}
