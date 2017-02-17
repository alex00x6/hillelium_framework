package base.mobile;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidSetup {
    protected AndroidDriver driver;

    protected void prepareAndroidForAppium(String path, String application) throws MalformedURLException {
        File appDir = new File(path);
        File app = new File(appDir, application);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("device","Android");
        desiredCapabilities.setCapability("deviceName","Android");
        desiredCapabilities.setCapability("app", app.getAbsolutePath());

        driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
    }

    protected void prepareAndroidForAppium(String path, String application, int port) throws MalformedURLException {
        File appDir = new File(path);
        File app = new File(appDir, application);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("app", app.getAbsolutePath());

        driver =  new AndroidDriver(new URL("http://127.0.0.1:"+port+"/wd/hub"), capabilities);
    }

    protected void prepareAndroidForAppium(String path, String application, String appPackage, String activity) throws MalformedURLException {
        File appDir = new File(path);
        File app = new File(appDir, application);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appWaitActivity", activity);


        capabilities.setCapability("app", app.getAbsolutePath());
        driver =  new AndroidDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
    }

    protected void prepareAndroid() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("androidPackage", "com.gamehivecorp.taptitans2");
        capabilities.setCapability("appActivity", "com.unity3d.player.UnityPlayerActivity");
        capabilities.setCapability("noReset", true);
        driver =  new AndroidDriver(new URL("http://127.0.0.1:4724/wd/hub"), capabilities);
    }
}