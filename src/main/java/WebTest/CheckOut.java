package WebTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.sound.midi.Soundbank;

public class CheckOut extends Utils {
    private  By _country = By.xpath( "//select[@id=\"CountryId\"]" );
    private  By _banladesh =By.xpath( "//option[contains(.,\"Bangladesh\")]" );
    private  By _zipCode=By.xpath( "//input[@id=\"ZipPostalCode\"]" );

    private  By _checkBox= By.xpath( "//input[@id=\"termsofservice\"]" );
    private By _checkOut=By.xpath( "//button[@id=\"checkout\"]" );
    private  By _checkOutAsGust=By.xpath( "//div/input[contains(@class,\"button-1 checkout-as-guest-button\")]" );

    private  By _firstName=By.xpath( "//input[@id=\"BillingNewAddress_FirstName\"]" );
    private  By _lastName=By.xpath( "//input[@id=\"BillingNewAddress_LastName\"]" );
    private By _email=By.xpath( "//input[@id=\"BillingNewAddress_Email\"]" );
    private By _countryDropDown=By.xpath("//select[@id=\"BillingNewAddress_CountryId\"]");
    private By _banladeshA = By.xpath( "//option[contains(.,\"Bangladesh\")]" );
    private By _cityName= By.xpath( "//input[@id=\"BillingNewAddress_City\"]" );
    private  By _address= By.xpath( "//input[@id=\"BillingNewAddress_Address1\"]" );
    private  By _zip=By.xpath( "//input[@id=\"BillingNewAddress_ZipPostalCode\"]" );
    private By _phoneNumber=By.xpath( "//input[@id=\"BillingNewAddress_PhoneNumber\"]" );



    private By _continue= By.xpath( "//input[contains(@onclick,\"Billing.save()\")]" );
    private By _continueAgain = By.xpath( "//input[contains(@onclick,\"ShippingMethod.save()\")]" );
    private  By _cridetCardPayment=By.xpath( "//label[contains( . ,\"Credit Card\")]" );
    private  By _continuePayment = By.xpath( "//input[contains(@onclick,\"PaymentMethod.save()\")]" );
    private By _creditcard= By.xpath( "//select[@id=\"CreditCardType\"]" );
    private  By _MasterCard=By.xpath( "//option[contains(. ,\"Master card\")]" );
    private  By _cardHolderName=By.xpath( "//input[@id=\"CardholderName\"]" );
    String Name="mdsa";
    private  By _cardNumber=By.xpath( "//input[@id=\"CardNumber\"]" );
    private By _monthDropDown=By.xpath("//select[@id=\"ExpireMonth\"]");
    private By _selectMonth=By.xpath("//option[contains(.,\"10\")]");
    private  By _yearDropDown=By.xpath( "id=\"ExpireYear\"" );
    private By _selectYear= By.xpath( "//option[contains(.,\"2020\")]" );
    private By _cardCode= By.xpath("//input[@id=\"CardCode\"]");
    private By _continueButton =By.xpath( "//input[@onclick=\"PaymentInfo.save()\"]" );
    private By _confirm=By.xpath( "//input[@onclick=\"ConfirmOrder.save()\"]" );
    private By _thankYou = By.xpath( "//h1[contains(.,\"Thank you\")]" );

    public void gustUserSuccessfullyCheckOut(){

        // enter country
        clickElement( _country );
        clickElement( _banladesh );

        //enter zip
        enterText( _zipCode,"rm5400");

        // select tik   trems check box
        WebElement termsOfserviceBox= driver.findElement( _checkBox );
        termsOfserviceBox.click();
        if (termsOfserviceBox.isSelected()){
            System.out.println("Box is selected");}

        // click check out
        clickElement( _checkOut );

        //click check out as a gust user

        clickElement( _checkOutAsGust );
//Enter Billing detail
        enterText( _firstName,"md" );
        enterText( _lastName,"sa" );
        enterText( _email,"masa@gmail.com" );
        clickElement( _countryDropDown );
        clickElement(_banladeshA );
        enterText( _cityName,"Rangpur" );
        enterText( _address,"14 staf roda" );
        enterText( _zip,"abc5400" );
        enterText( _phoneNumber,"47347343434383" );


        clickElement( _continue );
        clickElement( _continueAgain );


        //check credit card
        WebElement creditCard=driver.findElement( _cridetCardPayment );
        creditCard.click();

        //click continue
        clickElement( _continuePayment );

        //enter payment information
        //click dropdown
        clickElement( _creditcard );
        clickElement( _MasterCard );
        enterText( _cardHolderName,Name );
        enterText( _cardNumber,"5186528479988003" );
        //clickElement( _monthDropDown );
        clickElement( _selectMonth );
        //clickElement( _yearDropDown );
        clickElement( _selectYear );
        enterText( _cardCode,"939" );
        clickElement( _continueButton );
        clickElement( _confirm );


        // asser thank you
        assertText( "Thank you",_thankYou );
        System.out.println("Thank You For CkeckOUT");


    }
}
