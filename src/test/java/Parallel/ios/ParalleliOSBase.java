package Parallel.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ParalleliOSBase {

    @Test
    public IOSDriver<MobileElement> getIOSDriver(String deviceName, String platformVersion, String udid, String wdaLocalPort, String port) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/ayyildiz/Library/Developer/Xcode/DerivedData/UIKitCatalog-fxrdyeygsclnwverqkwwjyntnxtx/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
        capabilities.setCapability("wdaLocalPort", wdaLocalPort);
        capabilities.setCapability(MobileCapabilityType.UDID,udid);
        capabilities.setCapability("noReset", "true");

        IOSDriver<MobileElement> driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:"+port+"/wd/hub"), capabilities);
        return driver;
    }
}
