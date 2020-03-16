package WebTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddToCart_FeaturedProducts extends Utils {


    //Locator for featured grid
    private By _listOfItems=By.xpath("//div[@class=\"product-item\"]");

    //Locator for item box
    private By _addToCart = By.cssSelector(".item-box>div input[value='Add to cart']");



    public void veryfyingFeaturedProducts() {


        List<WebElement> productList = driver.findElements( By.xpath( "//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div" ) );
        for (WebElement element : productList) {
            // System.out.println( element.getText() );
            //boolean present = true;

            element.getText();

            for (int i = 0; i < element.getText().length(); i++) {

                if (driver.findElement( By.xpath( "//input[@class=\"button-2 product-box-add-to-cart-button\"]" ) ).isDisplayed()) {

                    driver.findElement( By.xpath( "//input[@class=\"button-2 product-box-add-to-cart-button\"]" ) ).click();
                    System.out.println("There is  Add to Button");
                }

                else
                    System.out.println( " There is Noooooooot  Add to Button " );
            }

        }
    }


    //To verify add to cart present
    public void verifyAddToCartPresentOnHomepageFeaturedItems()
    {   //List
        List<WebElement> listOfItems=driver.findElements(_listOfItems);
        //To count add to cart count
        int actualAddToCartCount = driver.findElements(_addToCart).size();
        //To print add to cart count
        System.out.println("Add to cart count is -------->>> "+actualAddToCartCount);
        int expectedAddToCartCount=4;
        //For each loop for all items
        for(WebElement item:listOfItems)
        {
            //To check if add to cart text is present or not
            if(item.getAttribute("innerHTML").contains("Add to cart"))
            {
                System.out.println(item.getText()+" : has Add to cart button");
            }
            else
                System.out.println(item.getText()+" : does not have Add to cart button");
            System.out.println("--------------------------------------------------------------------------");


        }
        //Comparing expected and actual number of add to cart button
        Assert.assertEquals("All product does not have Add to cart button: ",expectedAddToCartCount,actualAddToCartCount);
    }




}