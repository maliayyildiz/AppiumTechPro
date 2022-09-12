package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium10 extends BaseClass{
    @Test
    public void test() throws MalformedURLException, InterruptedException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//        capabilities.setCapability(MobileCapabilityType.APP, "/Users/ayyildiz/IdeaProjects/AppiumTechpro/src/Apps/apiDemos.apk");
////        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
////        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
//        capabilities.setCapability("noReset","true");
//
//        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        AndroidDriver driver = getAndroidDriver();

        System.out.println("App intstalled...");
        //api demos butonuna tikla
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(3000);
//preference butonuna tikladik
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        //preference dependencies butonuna bastik
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        //check box check et
        Thread.sleep(3000);
        driver.findElementById("android:id/checkbox").click();
        //wifi setting tikladik
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        //text penceresi acildigini gorduk
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElementById("android:id/alertTitle").isDisplayed());
        //text yazdiralim
        driver.findElementById("android:id/edit").sendKeys("TextAppium");
        //ok butonuna bas
        driver.findElementById("android:id/button1").click();

        System.out.println("mission completed....");

        Thread.sleep(10000);
        //session kapat

        driver.closeApp();
    }
}
