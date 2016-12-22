import base.mobile.AndroidSetup;
import models.linkedinmobile.HomePage;
import models.linkedinmobile.LoginPage;
import models.linkedinmobile.MessagePage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AppiumTest extends AndroidSetup {
    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium("src/main/resources/models/linkedin", "linkedin-4-0-98.apk");
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }


    @Test
    public void loginTest() {

        new LoginPage(driver).loginIntoProfile();
    }


    @Test
    public void searchTest(){

        new HomePage(driver)
                .searchFor("Arthur Pi")
                .selectResultListItem("Arthur Pilyuk")
                .clickOnMessageButton();
    }


    @Test
    public void sendMessageToContact(){

        new MessagePage(driver)
                .createMessage()
                .checkForSending();
    }

    @Test
    public void pressBack(){
        driver.findElement(By.className("android.widget.ImageButton")).click();

    }




    @Test
    public void testSwipeOnHomePage()  {
        new HomePage(driver).swipeFromRightToPullMenu();

    }


    @Test
    public  void testScrollUponHomePage(){
        new HomePage(driver).scrollUponHomePage();

    }

    @Test
    public void fullTestOfBackButton(){
        new LoginPage(driver).loginIntoProfile();
        new HomePage(driver)
                .searchFor("Arthur Pi")
                .selectResultListItem("Arthur Pilyuk")
                .clickOnMessageButton();
        driver.findElement(By.className("android.widget.ImageButton")).click();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}

