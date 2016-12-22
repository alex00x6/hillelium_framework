package models.linkedinmobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Storm on 20.12.2016.
 */
public class ResultListPage extends HomePage {

    public ResultListPage(WebDriver driver){

        super(driver);
    }

    By searchResult = By.id(app_package_name + "typeahead_item_view");
    By searchResultItemText = By.id(app_package_name + "type_ahead_large_view_first_text");

    public ResultPage selectResultListItem(String keyword){

        waitForVisibilityOf(searchResult);

        if(driver.findElement(searchResultItemText).getText().contains(keyword)){

            List<WebElement> results = driver.findElements(searchResult);
            results.get(0).click();

            return new ResultPage(driver);
        }

        System.out.println("Couldn't find the result");
        return null;
    }

}

