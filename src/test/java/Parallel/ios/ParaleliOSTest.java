package Parallel.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.HashMap;

public class ParaleliOSTest extends ParalleliOSBase{

    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        IOSDriver<MobileElement> driver = getIOSDriver("iPhone12","14.5","14C8B848-B927-44D4-8000-A995DB82E886","8100","10000");
        Thread.sleep(5000);
        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction","down");
        scrollObject.put("value", "Web View");
        driver.executeScript("mobile:scroll", scrollObject);

    }

    @Test
    public void test02() throws MalformedURLException, InterruptedException {
        IOSDriver<MobileElement> driver = getIOSDriver("iPhone8","14.5","A146FAA0-8C74-478C-8CC7-F1D32B92E08E","8200","10001");
        Thread.sleep(5000);
        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction","down");
        scrollObject.put("value", "Web View");
        driver.executeScript("mobile:scroll", scrollObject);
    }
}
