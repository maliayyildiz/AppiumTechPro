import ECommerceApp.BaseECommerceApp;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.List;


public class ReusableMethods extends BaseECommerceApp {

    private AndroidDriver<MobileElement> driver = getAndroidDriver();

    public ReusableMethods() throws MalformedURLException {
    }
    public void tapOnElementWithText(String text) {
        List<MobileElement> mobileElementList = driver.findElementsByClassName("android.widget.TextView");
        for (MobileElement page : mobileElementList) {
            if (page.getText().equals(text)) {
                page.click();
            } else {
                scrollWithUiScrollable(text);
            }
            break;
        }
    }

    //ikinci alternatif bir method
    public void clickOnElementWithText(String elementText) throws InterruptedException {
        Thread.sleep(4000);
        List<MobileElement> mobileElementList = driver.findElementsByXPath("//android.widget.TextView[@text='" + elementText + "']");
        if (mobileElementList.size() > 0) {
            mobileElementList.get(0).click();
        } else scrollWithUiScrollable(elementText);
    }


    public boolean isElementPresent(String text) {
        boolean elementFound = false;
        List<MobileElement> mobileElementList = driver.findElementsByXPath("//android.widget.TextView[@text='" + text + "']");
        for (MobileElement el : mobileElementList) {
            if (el.getText().equals(text)) {
                waitToBeVisible(el, 10);
                if (el.isDisplayed()) {
                    elementFound = true;
                }
            }
        }
        return elementFound;
    }

    public void wait(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tapOn(MobileElement element) {
        waitToBeClickable(element, 10);
        element.click();
    }

    public void enterText(MobileElement element, String text) {
        waitToBeClickable(element, 10);
        element.sendKeys(text);
    }

    public void enterText(MobileElement element, String text, boolean needClear) {
        waitToBeClickable(element, 10);
        if (needClear) {
            element.clear();
        }
        element.sendKeys(text);
    }

    public boolean isElementPresent(MobileElement mobileElement) {
        boolean elementFound = false;
        waitToBeVisible(mobileElement, 10);
        if (mobileElement.isDisplayed()) {
            elementFound = true;
        }
        return elementFound;
    }

    public void waitToBeVisible(MobileElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitToBeClickable(MobileElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollWithUiScrollable(String elementText) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
        tapOn(driver.findElementByXPath("//android.widget.TextView[@text='" + elementText + "']"));
    }

    public static void scrollDownToBeVisible(MobileElement element) {

    }

    public static void scrollUpToBeVisible(MobileElement element) {

    }

    public static void swipeFromElementToElement(MobileElement el1, MobileElement el2) {

    }
//attribute check


}
