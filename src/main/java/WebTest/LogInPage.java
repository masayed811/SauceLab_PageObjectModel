package WebTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LogInPage extends Utils {
    LoadProp loadProp = new LoadProp();

    private By _email = By.className("email");
    private By _password = By.className("password");
    private By _logInButton =  By.xpath( "//input[@class=\"button-1 login-button\"]" );
    private By _logInButton1 =  By.linkText("Log in"); //  By.xpath("//input[@class= 'button-1 login-button' and @value= 'Log in']");
    private By _logOutButton = By.xpath( "//a[@class=\"ico-logout\"]" ); //By.linkText("Log out");
    private By _logInMessage = By.xpath("//div[@class='message-error validation-summary-errors']");
    private By _emailError = By.xpath("//span[@id='Email-error']");



    public void clickOnLogInButton ()
    {


        waitForElementClickable(_logInButton1,10);
        clickElement(_logInButton1);

    }

    public void verifyUserIsOnLogInPage()
    {
        assertWithURL("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }


    public void EnterLogInDetails() {
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        enterText( _email, loadProp.getProperty( "email1" ) );
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        enterText( _password, loadProp.getProperty( "password" ) );

        clickElement( _logInButton );
    }
    public void userLogInSuccessfully(){
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        assertText( "Log out",_logOutButton );


    }

}

