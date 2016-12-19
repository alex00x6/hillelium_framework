import base.mobile.AndroidSetup;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class Vhacktest extends AndroidSetup {

    @BeforeTest
    public void setUp() throws MalformedURLException {
        prepareAndroidForAppium("src/main/resources/models/vhack", "vHack_1.42.apk");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }


    public void vhackPressBack(){
        driver.pressKeyCode(4);
    }

    public void vhackUpgradeSDK5(){

        driver.findElement(By.id("org.vhack.dev.vhack:id/btnSoftware")).click();
        driver.findElement(By.xpath("//android.widget.LinearLayout[@index='3']")).click();
        for(int i = 0; i < 5; i++){
            driver.findElement(By.id("org.vhack.dev.vhack:id/btnBuy1")).click();
        }
    }

    public void vhackUpgradeScan5(){
        driver.findElement(By.id("org.vhack.dev.vhack:id/btnSoftware")).click();
        driver.findElement(By.xpath("//android.widget.LinearLayout[@index='6']")).click();
        for(int i = 0; i < 5; i++){
            driver.findElement(By.id("org.vhack.dev.vhack:id/btnBuy1")).click();
        }
    }

    @Test
    public void vhackFarm2(){
        driver.findElement(By.id("org.vhack.dev.vhack:id/btnSwitch")).click();

        driver.findElement(By.id("org.vhack.dev.vhack:id/txtLoginUser")).sendKeys("alex00x6");
        driver.findElement(By.id("org.vhack.dev.vhack:id/txtLoginPass")).sendKeys("652113");
        driver.findElement(By.id("org.vhack.dev.vhack:id/btnOLogin")).click();

        driver.findElement(By.id("android:id/button1")).click();

        driver.findElement(By.id("org.vhack.dev.vhack:id/btnNetwork")).click();

        for(int i5 = 0; i5 < 15; i5++) {
            for (int i2 = 0; i2 < 10; i2++) {
                for (int i = 1; i <= 9; i++) {
                    driver.findElement(By.id("org.vhack.dev.vhack:id/txtFW" + i)).click();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String chance = driver.findElement(By.id("org.vhack.dev.vhack:id/txtConsoleWindow")).getAttribute("text");
                        if (chance.contains("Trojan success chance: 90%") || chance.contains("Trojan success chance: 80%")){
                        driver.findElement(By.id("org.vhack.dev.vhack:id/btnTransferIP")).click();
                    }
                }
                String s2 = driver.findElement(By.id("org.vhack.dev.vhack:id/txtIP1")).getAttribute("text");
                driver.findElement(By.id("org.vhack.dev.vhack:id/btnNetworkRefresh")).click();
                String s3 = driver.findElement(By.id("org.vhack.dev.vhack:id/txtIP1")).getAttribute("text");
                if (s2.equals(s3)) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            vhackPressBack();
            vhackUpgradeSDK5();
            vhackPressBack();
            vhackUpgradeScan5();
            vhackPressBack();
            driver.findElement(By.id("org.vhack.dev.vhack:id/btnNetwork")).click();
        }

        System.out.println("WHOA, done");

    }

    @Test
    public void vhackFarm() {
        driver.findElement(By.id("org.vhack.dev.vhack:id/btnSwitch")).click();

        driver.findElement(By.id("org.vhack.dev.vhack:id/txtLoginUser")).sendKeys("alex00x6");
        driver.findElement(By.id("org.vhack.dev.vhack:id/txtLoginPass")).sendKeys("652113");
        driver.findElement(By.id("org.vhack.dev.vhack:id/btnOLogin")).click();

        driver.findElement(By.id("android:id/button1")).click();

        driver.findElement(By.id("org.vhack.dev.vhack:id/btnNetwork")).click();

        for(int i5 = 0; i5 < 3; i5++) {
            for (int i2 = 0; i2 < 10; i2++) {
                for (int i = 1; i <= 9; i++) {
                    String s = driver.findElement(By.id("org.vhack.dev.vhack:id/txtFW" + i)).getAttribute("text");
                    int i1 = Integer.parseInt(s);
                    if (i1 < 32) {
                        driver.findElement(By.id("org.vhack.dev.vhack:id/txtFW" + i)).click();
                        driver.findElement(By.id("org.vhack.dev.vhack:id/btnTransferIP")).click();
                    }
                }
                String s2 = driver.findElement(By.id("org.vhack.dev.vhack:id/txtIP1")).getAttribute("text");
                driver.findElement(By.id("org.vhack.dev.vhack:id/btnNetworkRefresh")).click();
                String s3 = driver.findElement(By.id("org.vhack.dev.vhack:id/txtIP1")).getAttribute("text");
                if (s2.equals(s3)) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            vhackPressBack();
            vhackUpgradeSDK5();
            vhackPressBack();
            vhackUpgradeScan5();
            vhackPressBack();
            driver.findElement(By.id("org.vhack.dev.vhack:id/btnNetwork")).click();
        }

        System.out.println("WHOA, done");

    }
}
