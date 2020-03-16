package WebTest;

import org.openqa.selenium.By;

public class ElectronicsPage extends Utils {
    private By _cellPhone= By.xpath( "//div/h2/a[contains(. ,\"Cell phones\")]" );
    private  By _nokiLumia=By.linkText( "Nokia Lumia 1020" ); //xpath("//h2/a[contains(.,\"Nokia Lumia 1020\")]");    //
    private  By _addTocart = By.xpath("//input[contains(@id ,\"add-to-cart-button-20\")]");
    private  By _shoppingCart= By.linkText( "shopping cart" );

    public void userIsOnElectronicPage(){
        //Assert user ne electronic page
        assertCurrentURLR( "https://demo.nopcommerce.com/electronics" );

    }
    public void navigateToCellPhone(){
        //click cell phone
        clickElement( _cellPhone );

        // select item
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        clickElement( _nokiLumia );
        // add to cart
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        clickElement( _addTocart );

        // click shopping cart link
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        clickElement( _shoppingCart );

    }
}
