package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium06NativeChrome {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage","com.android.chrome");
        capabilities.setCapability("appActivity","org.chromium.chrome.browser.ChromeTabbedActivity");
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.get("https://www.amazon.com");

        System.out.println(driver.getContext() + "<====app acildigindaki tur");
        //burda aplikasyonun hangi turleri oldugunu gorem icin getContextHandles() kullaniyoruz.
//        Set<String> butunturler = driver.getContextHandles();
//        for (String tur: butunturler) {
//            System.out.println(tur);
//            if (tur.contains("WEBVIEW_chrome")) {
//                driver.context(tur);
//            }
//        }

        System.out.println(driver.getContext() + "<====degisimden sonraki tur");
        Thread.sleep(7000);

        MobileElement homeScreenLogo = driver.findElementByAccessibilityId("Amazon");
        Assert.assertTrue(homeScreenLogo.isDisplayed());
        System.out.println("Ana sayfadayiz");

//        System.out.println(driver.getCurrentUrl() +"<========= url ");
        Thread.sleep(3000);
        MobileElement signInButton = driver.findElementByAccessibilityId("Sign in ›");
        signInButton.click();
        Thread.sleep(5000);
        MobileElement welcomeText = driver.findElementByXPath("//android.widget.TextView[@text='Welcome']");

        Assert.assertEquals(welcomeText.getText(),"Welcome");

        System.out.println("test bitt...");
        Thread.sleep(5000);
        //close session
        driver.closeApp();

        


    }
}
