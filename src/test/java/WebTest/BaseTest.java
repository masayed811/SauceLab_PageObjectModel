package WebTest;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest extends Utils {

    BrowserSelector browserSelector=new BrowserSelector();
    @BeforeTest
    public void openBrowse() {
        browserSelector.setUpBrowser();
        driver.get( "https://demo.nopcommerce.com/" );
    }

//        @AfterTest
//        public  void closeBrowser(){
//        browserSelector.closeBrowser();
//    }

}

