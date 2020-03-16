package WebTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserSelector extends Utils {
    public static LoadProp loadProp = new LoadProp();


    public static final String USERNAME = loadProp.getProperty( "SAUCE_USERNAME" );
    public static final String ACCESS_KEY = loadProp.getProperty( "SAUCE_ACESS_KEY" );
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com/wd/hub";

    public static final boolean SAUCE_LAB = Boolean.parseBoolean( System.getProperty( "Sauce" ) );

    public static final String browser = System.getProperty( "browser" );




    public void setUpBrowser() {

        System.out.println( USERNAME );
        System.out.println( ACCESS_KEY );

        //if sauce lab is true........................................
        if (SAUCE_LAB) {


            System.out.println( "Running in SauceLap..............with browser" + browser );

            if (browser.equalsIgnoreCase( "Chrome" )) {
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability( "platform", "Windows 8" );
                caps.setCapability( "version", "78.0" );

                try {
                    driver = new RemoteWebDriver( new URL( URL ), caps );
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            if (browser.equalsIgnoreCase( "IE" )) {
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setCapability( "platform", "Windows 10" );
                caps.setCapability( "version", "11" );

                try {
                    driver = new RemoteWebDriver( new URL( URL ), caps );
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            if (browser.equalsIgnoreCase( "FireFox" )) {
                DesiredCapabilities caps = DesiredCapabilities.firefox();
                caps.setCapability( "platform", "Windows 7" );
                caps.setCapability( "version", "56" );
                caps.setCapability( "name" ,"Testing on Firefox 56");

                try {
                    driver = new RemoteWebDriver( new URL( URL ), caps );
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            if (browser.equalsIgnoreCase( "Safari" )) {
                DesiredCapabilities caps = DesiredCapabilities.safari();
                caps.setCapability( "platform", "OS X 10.10" );
                caps.setCapability( "version", "8.0" );

                try {
                    driver = new RemoteWebDriver( new URL(URL), caps );
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            if (browser.equalsIgnoreCase( "edge" )) {
                DesiredCapabilities caps = DesiredCapabilities.edge();
                caps.setCapability( "platform", "Windows 10" );
                caps.setCapability( "version", "16.16299" );

                try {
                    driver = new RemoteWebDriver( new URL( URL ), caps );
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println( "Wronge browser name  or empty : " + browser );

            }
        }



        else {

            if (browser.equalsIgnoreCase( "firefox" )) {

                System.setProperty( "webdriver.gecko.driver", "src\\test\\Resources\\BrowserDriver\\geckodriver.exe" );
                System.setProperty( FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true" );
                System.setProperty( FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null" );

                driver = new FirefoxDriver();
                driver.manage().window().fullscreen();

            } else if (browser.equalsIgnoreCase( "chrome" )) {
                System.setProperty( "webdriver.chrome.driver", "src\\test\\Resources\\BrowserDriver\\chromedriver.exe" );
                ChromeOptions options = new ChromeOptions();
                options.addArguments( "--disable-infobars" );
                options.addArguments( "--disable-extension" );
                options.addArguments( "--disable-setUpBrowser-side-navigation" );
                options.addArguments( "--incognito" );
                options.addArguments( "--disable-blink-features-BlockCredentialeSubresources" );
                driver = new ChromeDriver( options );
                driver.manage().timeouts().implicitlyWait( 20, TimeUnit.SECONDS );
                driver.manage().window().fullscreen();

            } else if (browser.equalsIgnoreCase( "ie" )) {
                System.setProperty( "webdriver.ie.driver", "src\\test\\Resources\\BrowserDriver\\IEDriverServer.exe" );
                System.out.println( "here" );
                InternetExplorerOptions options = new InternetExplorerOptions();
                options.setCapability( InternetExplorerDriver.IE_SWITCHES, "-privet" );
                options.setCapability( InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true );
                driver = new InternetExplorerDriver( options );
                driver.manage().window().maximize();

            } else {
                System.out.println( "Browser name is empty or trped wrong" + browser );
            }
        }

    }

    public void closeBrowser() {

        driver.close();
    }

}