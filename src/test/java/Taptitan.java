import base.mobile.AndroidSetup;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class Taptitan extends AndroidSetup{

    @BeforeTest
    public void before() throws MalformedURLException {
        prepareAndroid();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.closeApp();
        driver.quit();
    }

    @Test
    public void tapTest(){

        sleep(55000);



        driver.tap(1, 50, 1250, 100); //tap on hero upgrade menu
        sleep(1000);

        for(int i1 = 0; i1 < 200; i1++) {
            driver.tap(1, 635,50, 100); //tap on "fight boss"
            sleep(1000);
            for (int i = 0; i < 300; i++) {
                driver.tap(1, 130, 630, 100);
                driver.tap(1, 350, 550, 100);
                driver.tap(1, 570, 630, 100);
                driver.tap(1, 600, 300, 100);
            }
            sleep(1000);
            driver.tap(1, 630, 900, 100); //upgrade 1st item
        }

    }

    private void sleep(int sleep){
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
