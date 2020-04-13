package com.tech;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DummyiOSTest {
    private static String serverUrl = "http://localhost:4723/wd/hub";
    private static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) throws MalformedURLException {
        System.out.println("Testing Calculator App!");

        connectWithAppiumServer();

        System.out.println("Testing Done!");
    }

    private static void connectWithAppiumServer() throws MalformedURLException {
        Capabilities capabilities = getDesiredCapabilities();
        URL appiumServerUrl = new URL(serverUrl);// Appium Server URL;

        //Send these desire capabilities to Appium Server
        driver = new IOSDriver<MobileElement>(appiumServerUrl, capabilities);

        System.out.println("Connected With Appium Server.");
    }

    /**
     * DesiredCapability = AboutDevice + AboutApplication
     * @return
     */
    private static DesiredCapabilities getDesiredCapabilities(){
        DesiredCapabilities cap = new DesiredCapabilities();

        //About Device
        cap.setCapability("platformName", "iOS");
        cap.setCapability("platformVersion", "10");
        cap.setCapability("deviceName", "iPhone 6");
        cap.setCapability(CapabilityType.BROWSER_NAME, "safari");

        //About Application
        cap.setCapability("app", "");

        return cap;
    }
}
