package WebTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ChangeCurrency extends Utils {
    private By _dropDown = By.xpath( "//select[@id=\"customerCurrency\"]" );
    private By _euro = By.xpath( "//option[contains(. ,\"Euro\")]" );
    private By _usDoller = By.xpath( "//option[contains(. ,\"US Dollar\")]" );

    SoftAssert softAssert = new SoftAssert();

    public void selectEuroFromDropDown() {
        //click dropdown manue
        clickElement( _dropDown );
        //select Euro
        clickElement( _euro );
//Asser all products have Euro sing

        List<WebElement> productList = driver.findElements( By.xpath( "//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div" ) );
        for (WebElement web : productList) {
            System.out.println( web.getText() );
            System.out.println( "**********************" );
            //  assertWithContainsText(web.getText(), "$" );
            softAssert.assertTrue( web.getText().contains( "Ђ" ), "Ђ not Found" + web.getText() );

        }

        softAssert.assertAll();
    }

    //select us doller and assert
    public void selectUsDoller(){
        clickElement( _dropDown );
        clickElement( _usDoller );
        List<WebElement> productList = driver.findElements( By.xpath( "//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div" ) );
        for (WebElement web : productList) {
            System.out.println( web.getText() );
            System.out.println( "**********************" );
            //  assertWithContainsText(web.getText(), "$" );
            softAssert.assertTrue( web.getText().contains( "$" ), "$ not Found" + web.getText() );

        }
        softAssert.assertAll();

    }

    // different Way to check currency is changed or not
    public void changeCurrencySuccessfullyAndChecked() {
        clickElement( _dropDown );
        clickElement( _usDoller );
        boolean present = false;
        List<WebElement> productList = driver.findElements( By.xpath( "//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div" ) );
        for (WebElement element : productList) {
            String str = element.getText();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt( i );
                if (ch == '$') {
                    present = true;
                    //index = i;
                }
            }
            if (present == true) {
                System.out.println( "$" + " is present in the  product price" );
                // break;
            } else {
                System.out.println( "The $ is not present at the array list" );
            }
        }
        // Checked for Euro


        clickElement( _dropDown );
        clickElement( _euro );
        List<WebElement> productList2 = driver.findElements( By.xpath( "//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div" ) );

        for (WebElement element : productList2) {
            String str = element.getText();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt( i );
                if (ch == 'Ђ') {
                    present = true;
                    //index = i;
                }
            }
            if (present == true) {
                System.out.println( "Ђ" + " is present in the  product price" );
                // break;
            } else {
                System.out.println( "The Ђ is not present at the array list" );
            }
        }

    }


}

