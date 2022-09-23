package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Formatter;
import java.util.Locale;

public class IQ {
    public static String format(String format, Object... args) {
        return new Formatter().format(format, args).toString();
    }
    @Test
    public void iq() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/ayyildiz/IdeaProjects/AppiumTechpro/src/Apps/Calculator.apk");
        capabilities.setCapability("deviceOrientation","landscape");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        Thread.sleep(3000);

        MobileElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement num2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement num4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        MobileElement num6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        MobileElement num7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        MobileElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        MobileElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");
        MobileElement num0 = driver.findElementById("com.google.android.calculator:id/digit_0");

        MobileElement plus = driver.findElementByAccessibilityId("plus");
        MobileElement multiply = driver.findElementById("com.google.android.calculator:id/op_mul");
        MobileElement divide = driver.findElementByAccessibilityId("divide");
        MobileElement minus = driver.findElementByAccessibilityId("minus");

        MobileElement equal = driver.findElementByAccessibilityId("equals");

        num2.click();
        num3.click();
        plus.click();
        num9.click();
        num5.click();
        equal.click();

        MobileElement result = driver.findElementById("com.google.android.calculator:id/result_final");
        String  resultString = result.getText();

        MobileElement suqare = driver.findElementById("com.google.android.calculator:id/op_sqrt");
        suqare.click();

        for (int i = 0; i < resultString.length(); i++) {
            switch (resultString.charAt(i)) {
                case '1':
                        num1.click();
                        break;
                case '2':
                    num2.click();
                    break;
                case '3':
                    num3.click();
                    break;
                case '4':
                    num4.click();
                    break;
                case '5':
                    num5.click();
                    break;
                case '6':
                    num6.click();
                    break;
                case '7':
                    num7.click();
                    break;
                case '8':
                    num8.click();
                    break;
                case '9':
                    num9.click();
                    break;
                case '0':
                    num0.click();
                    break;
                default:
                    System.out.println("no digit value");
            }
        }

        equal.click();

        Thread.sleep(3000);

        multiply.click();

        minus.click();
        num1.click();

        equal.click();

        MobileElement result2 = driver.findElementById("com.google.android.calculator:id/result_final");
        String carpimSonrasiSonuc = result2.getText();

        String ex = "-10.862782780491200215723891499337473741120";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(carpimSonrasiSonuc,ex);



//        String rounding=format("%.4f", carpimSonrasiSonuc);
        String rounding = carpimSonrasiSonuc.substring(1);
        String numericSonuc = rounding;
        double doubleSonuc = Double.parseDouble(numericSonuc);
        System.out.println(doubleSonuc +"=======");
        doubleSonuc =  Math.round(doubleSonuc*10000.0)/10000.0 *(-1);
        System.out.println(doubleSonuc);
        double exrounding = -10.8628;

        softAssert.assertEquals(doubleSonuc,exrounding);

        softAssert.assertAll("Actual and expected sonuc ayni degil");





    }
}
