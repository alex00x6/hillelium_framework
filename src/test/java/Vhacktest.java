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
        prepareAndroidForAppium("src/main/resources/models/vhack","vHack_1.42.apk");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.closeApp();
        driver.quit();
    }

    @Test
    public void vhackUpgrade(){
        driver.findElement(By.id("org.vhack.dev.vhack:id/btnSwitch")).click();

        driver.findElement(By.id("org.vhack.dev.vhack:id/txtLoginUser")).sendKeys("alex00x6");
        driver.findElement(By.id("org.vhack.dev.vhack:id/txtLoginPass")).sendKeys("652113");
        driver.findElement(By.id("org.vhack.dev.vhack:id/btnOLogin")).click();

        driver.findElement(By.id("android:id/button1")).click();

        openUpgrades();
        vhackUpgradeFirewall();
        vhackUpgradeAntivirus();
        vhackUpgradeSDK();
        vhackUpgradeIP();
        vhackUpgradeSpam();
        vhackUpgradeScan();
        vhackUpgradeSpyware();
        vhackPressBack();
    }

    public void vhackPressBack(){
        driver.pressKeyCode(4);
    }

    public void openUpgrades(){
        driver.findElement(By.id("org.vhack.dev.vhack:id/btnSoftware")).click();
    }

    public void vhackUpgradeFirewall(){

        driver.findElementByName("Firewall").click();
        for(int i = 0; i < 2; i++){
            driver.findElement(By.id("org.vhack.dev.vhack:id/btnBuy1")).click();
        }
    }
    public void vhackUpgradeAntivirus(){

        driver.findElementByName("Antivirus").click();
        for(int i = 0; i < 2; i++){
            driver.findElement(By.id("org.vhack.dev.vhack:id/btnBuy1")).click();
        }
    }

    public void vhackUpgradeSDK(){

        driver.findElementByName("SDK").click();
        for(int i = 0; i < 2; i++){
            driver.findElement(By.id("org.vhack.dev.vhack:id/btnBuy1")).click();
        }
    }

    public void vhackUpgradeIP(){

        driver.findElementByName("IP-Spoofing").click();
        for(int i = 0; i < 2; i++){
            driver.findElement(By.id("org.vhack.dev.vhack:id/btnBuy1")).click();
        }
    }

    public void vhackUpgradeSpam(){

        driver.findElementByName("Spam").click();
        for(int i = 0; i < 2; i++){
            driver.findElement(By.id("org.vhack.dev.vhack:id/btnBuy1")).click();
        }
    }

    public void vhackUpgradeScan(){
        driver.findElementByName("Scan").click();
        for(int i = 0; i < 2; i++){
            driver.findElement(By.id("org.vhack.dev.vhack:id/btnBuy1")).click();
        }
    }

    public void vhackUpgradeSpyware(){
        driver.findElementByName("Spyware").click();
        for(int i = 0; i < 2; i++){
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
                    sleep(5000);
                    String chance = driver.findElement(By.id("org.vhack.dev.vhack:id/txtConsoleWindow"))
                            .getAttribute("text");
                    sleep(3000);
                        if (chance.contains("Trojan success chance: 90%") ||
                                chance.contains("Trojan success chance: 80%") || chance.contains("Trojan success chance: 70%")){
                        driver.findElement(By.id("org.vhack.dev.vhack:id/btnTransferIP")).click();
                    }
                }
                String s2 = driver.findElement(By.id("org.vhack.dev.vhack:id/txtIP1")).getAttribute("text");
                driver.findElement(By.id("org.vhack.dev.vhack:id/btnNetworkRefresh")).click();
                String s3 = driver.findElement(By.id("org.vhack.dev.vhack:id/txtIP1")).getAttribute("text");
                if (s2.equals(s3)) {
                    sleep(3000);
                }
            }
            vhackPressBack();
            openUpgrades();
            vhackUpgradeFirewall();
            vhackUpgradeAntivirus();
            vhackUpgradeSDK();
            vhackUpgradeIP();
            vhackUpgradeSpam();
            vhackUpgradeScan();
            vhackUpgradeSpyware();
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
            vhackUpgradeSDK();
            vhackPressBack();
            vhackUpgradeScan();
            vhackPressBack();
            driver.findElement(By.id("org.vhack.dev.vhack:id/btnNetwork")).click();
        }

        System.out.println("WHOA, done");

    }

    public void sleep(int mills){
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
