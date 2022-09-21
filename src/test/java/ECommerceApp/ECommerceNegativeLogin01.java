package ECommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ECommerceNegativeLogin01 extends BaseECommerceApp{
    /*
    //1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
    //1- hatali data ile form doldurdugunuzda hata mesajini dogrulayin
//2-Shop the items in the app by scrolling to specific Product and add to cart
//3-Validate if the items selected in the page 2 are matching with the items displayed in check out page
//4- Validate the total Amount displayed in the checkout page matches with sum of product amounts selected for shopping
//5-Validate Mobile gestures working for link (long press) and navigate to WebView //6-Verify if user can do operations on Web view and navigate back to native app if needed.
(go to google and search “appium” then navigate to NATIVE APP and verify it)

     */


    @Test
    public void negativeTest() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver = getAndroidDriver();
        Thread.sleep(7000);
        //1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
        //1- hatali data ile form doldurdugunuzda hata mesajini dogrulayin

        MobileElement homeScreenTitle = driver.findElementById("toolbar_title");
        MobileElement countrySpinner = driver.findElementById("spinnerCountry");


        MobileElement nameBox = driver.findElementById("com.androidsample.generalstore:id/nameField");
        MobileElement maleRadioButton = driver.findElementById("com.androidsample.generalstore:id/radioMale");
        MobileElement femaleRadioButton = driver.findElementById("com.androidsample.generalstore:id/radioFemale");
        MobileElement letsShopButton = driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");

//ana sayfa da miyiz? onayladik

        //ulkeyi secmek icin ulke butununa bastik
        countrySpinner.click();
        //ulkeyi sececegiz
        Thread.sleep(4000);
        MobileElement expectedCountry = driver.findElementByXPath("//android.widget.TextView[@text='Angola']");
        expectedCountry.click();
        Thread.sleep(5000);
        //istedigimiz ulkeyi dogru olarak sectik mi?
        MobileElement selectedCountry = driver.findElementByXPath("//android.widget.TextView[@text='Angola']");
        System.out.println(selectedCountry.getText());
        Assert.assertEquals(selectedCountry.getText(), "Angola");
        Thread.sleep(3000);
//negative case icin name bos olmali
//        Assert.assertTrue(nameBox.getText().isEmpty());
        nameBox.clear();
        //female secilsin
        femaleRadioButton.click();
        //shop butonuna tiklayalim
        letsShopButton.click();
//hata mesajini onayla
        Thread.sleep(2000);
        MobileElement errorPopUpText = driver.findElementByXPath("//android.widget.Toast");
        String errorText = errorPopUpText.getText();
        Assert.assertEquals(errorText, "Please enter your name");

        //close app
        driver.closeApp();

    }
}
