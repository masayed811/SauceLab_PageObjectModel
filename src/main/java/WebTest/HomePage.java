package WebTest;

import org.openqa.selenium.By;

public class HomePage extends Utils {
    private By _electronic = By.xpath( "//div/h2/a[contains(. ,\" Electronics \")]" );
    private  By _detailsButton= By.xpath( "//div[2]/div/a[contains( . ,\"details\")]" );



    LoadProp loadProp =new LoadProp();
    // assert User on Home Page
    public  void userIsOnHomePage(){
        assertCurrentURLR( "https://demo.nopcommerce.com/" );
        System.out.println(" This is Home Page Ready for Operation Hahahahahahahah");
    }
    public void userNavigateToElectronicsPage(){
        //click electronic to navigate
        clickElement( _electronic );

    }


    public void userNavigatTonopCommerceNewsReleasePage(){
        // click on details for Write comment
        clickElement( _detailsButton );



    }


}
