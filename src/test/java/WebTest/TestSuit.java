package WebTest;

import org.testng.annotations.Test;

public class TestSuit extends  BaseTest {
    HomePage homePage =new HomePage();
    ChangeCurrency changeCurrency =new ChangeCurrency();
    AddToCart_FeaturedProducts addToCart_featuredProducts =new AddToCart_FeaturedProducts();
    ElectronicsPage electronicsPage = new ElectronicsPage();
    CheckOut checkOut =new CheckOut();
    Comment comment = new Comment();
    LogInPage logInPage = new LogInPage();



    @Test
    public void userSuccessfullyChangeCurrency(){
        homePage.userIsOnHomePage();
        changeCurrency.selectEuroFromDropDown();
        changeCurrency.selectUsDoller();
    }
    @Test
    public void changedCurrencyWithChecked(){
        changeCurrency.changeCurrencySuccessfullyAndChecked();
    }

    @Test
    public void userVeryfyAddToCutButtonSuccessfully(){
        homePage.userIsOnHomePage();
        //addToCart_featuredProducts.veryfyingFeaturedProducts();
        addToCart_featuredProducts.verifyAddToCartPresentOnHomepageFeaturedItems();
    }
    @Test
    public void gustUserShouldCheckOutSuccessfully(){
        homePage.userIsOnHomePage();
        homePage.userNavigateToElectronicsPage();
        electronicsPage.userIsOnElectronicPage();
        electronicsPage.navigateToCellPhone();
        checkOut.gustUserSuccessfullyCheckOut();

    }
    @Test
    public void gustUserShouldmadeCommentSuccessfully(){
        homePage.userIsOnHomePage();
        homePage.userNavigatTonopCommerceNewsReleasePage();
        comment.userIsOnNewReleasePageForComment();
    }

    @Test
    public void userSuccessfullyLogIn(){
        homePage.userIsOnHomePage();
        logInPage.clickOnLogInButton();
        logInPage.verifyUserIsOnLogInPage();
        logInPage.EnterLogInDetails();
        logInPage.userLogInSuccessfully();


    }
//user is on home page
    // click on details for write comment
    // user is on nopCommerce new release page
    //  enter the title
    // enter comments
    //click on new comment
    //asert comment is on the page

}
