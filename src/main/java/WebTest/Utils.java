package WebTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

public class Utils extends BasePage {

    //1) Clicking element

    public static void clickElement(By by){
        driver.findElement(by).click(); }

    //2) Clear Text form inout box/area

    public static void clearTextBox(By by){
        driver.findElement( by ).clear();     }

    //3)  Enter text in input field

    public static void enterText(By by,String text){
        driver.findElement( by ).sendKeys( text );
    }


    //4 ENTER ELEMENT
    public static void enterElement(By by,String text){
        driver.findElement( by ).sendKeys( text );
    }
//5)  Clear and enter text in input field

    public static void clearAndEnterText(By by , String text){
        driver.findElement( by ).clear();
        driver.findElement( by ).sendKeys(text );
    }

    //6)  Checking Web Element is present   /Check web element is present in DOM

    public boolean isElementPresent(By by){
        try {
            driver.findElement( by ).isEnabled();
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

// 7)  Checking Web Element displayed or not ///  Check web element is displayed or not with try and catch

    public boolean isElementDisplayed(By by){
        try {
            driver.findElement( by ).isDisplayed();
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

//  if  Button is Present than Click

    public void isElementPresentAndClick(By by ){
        if(driver.findElement(by).isDisplayed())
        {
            driver.findElement(by).click();
        }
        else
            System.out.println("Show more is not there");
    }


//9)  Wait for Locator fixed time given in seconds /Wait for fixed time given in seconds *please check*

    public static void waitForLocatorClickable(By by,int second){
        WebDriverWait wait =new WebDriverWait( driver ,second );
        wait.until( ExpectedConditions.elementToBeClickable( by ) );
    }

    // 10)  Wait for Element to be clickable for given time in seconds
    public static void waitForElementClickable(By by , int second){
        WebDriverWait wait = new WebDriverWait( driver,second );
        wait.until( ExpectedConditions.elementToBeClickable( by ) );
    }


// 11)  Wait for element Locator  for given time in second

    public static void waitForElementLocatorClickable(By by,int second){
        WebDriverWait wait= new WebDriverWait( driver,second );
        wait.until( ExpectedConditions.visibilityOfAllElementsLocatedBy( by ) );
    }

    //  13 )wait for element to be visible
    public static void waitForElementVisible(By by,int second){
        WebDriverWait wait =new WebDriverWait( driver,second );
        wait.until( ExpectedConditions.visibilityOfAllElementsLocatedBy( by ) );
    }


    //  13 )wait for element to be invisible
    public static void waitForElementInvisible(By by , int second){
        WebDriverWait wait = new WebDriverWait( driver,second );
        wait.until( ExpectedConditions.invisibilityOfElementLocated( by ) );
    }



//8)  Try to click element 3-three times if not available in first go


// 12)  Wait for element for given time in second


//14) Wait for alert to display / Wait for alert to display *Not Checked*


//15) Get attribute of element

    public static  void getAttributeOfElement(By by ,String text){
        driver.findElement( by ).getAttribute( text );
    }


// 16) get css property of element /Get css property of element

    public static void getCssProoerty(By by , String text ){
        driver.findElement( by ).getCssValue( text );
    }

    // 17)Get text from the element
    public static void getText(By by ,String text){
        driver.findElement( by ).getText();
    }

//18) get visibility text/    // select from visible text

    public static void getVisibilityText(By by, String text){
        Select select = new Select( driver.findElement( by ) );
        select.selectByVisibleText( text );
    }

// 22) Select from visible number

    public static void selectVisibleNumber(By by ,int number ){
        Select select = new Select( driver.findElement( by ) );
        select.selectByIndex( number );
    }

    //23) Select from value
    public static void selectFromValue(By by ,int number){
        Select select = new Select( driver.findElement( by ) );
        select.selectByIndex( number );
    }


// 24 ) select text by value  // For DOB , currecny

    public static  void selectTextValue(By by,String data){
        Select select = new Select( driver.findElement( by ) );
        select.selectByValue( data );
    }

//// 25) get selected value from dropdown/18) get selected value from dropdown
//
//    public static void selectValueFromDropdown(By by, String data){
//        Select select = new Select( driver.findElement( by ) );
//        select.selectByValue( data );

    //26 Get selected value from dropdown
    public static String selectValueFromDropdown(By by) {
        driver.findElement(by).isDisplayed();
        Select dropBox = new Select(driver.findElement(by));
        return dropBox.getFirstSelectedOption().getText();}

    public static String currentTimeStamp() {
        return new SimpleDateFormat( "yyyy.MM.dd.HH.mm.ss" ).format( new Date(  ) );

    }
    //  19) date stamp short

    //20) date stamp long


// 26) is Dorpdown present /Is Dropdown present
// 27)  Fro Drop down if Text is present
// 28) Scroll to view element
//29)Scroll to element and click
//30 )a Scroll to view element using action class
//31)a Scroll to element and click using action class
//32)b Scroll to element and click random element

    //33) hover to element mouse hover method
    public void hoverElement(By by){
        // xpath store in ele or we can use direct
        WebElement ele = driver.findElement( by );
        Actions act = new Actions( driver );

        // single element .perform if multiple we use  build.perform

        act.moveToElement( ele ).perform();
    }




    //34 )  Method for call Assort
    public static String getTextMassage(By by ){
        return null;
    }

// 35 )  Assert with contains Text // Assert Text Message

    public static void assertText(String Expected ,By by) {
        Assert.assertEquals( Expected,driver.findElement( by ).getText() );

    }

    // 36) assert URL ///37) Get URL
    public static void assertU(String text){
        String CurrentURL=driver.getCurrentUrl();
        Assert.assertEquals(CurrentURL,"text" );
    }
    //36) assert URL ///37) Get URL
    public static void assertCurrentURL(String ExpectedCurrentURL,By by){
        Assert.assertTrue( ExpectedCurrentURL.equals( driver.getCurrentUrl() ));

    }

// 22) assert  urll

    public static void assertCurrentURL(String URL) {

        Assert.assertTrue( driver.getCurrentUrl().equals( URL ) );
    }
    //23
    public static void assertURL(String text) {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals( URL,"text");

    }
    public static void assertWithURL(String text1 ) {
        String URL = driver.getCurrentUrl();
        Assert.assertTrue(URL.contains(text1));

    }
    // Assert with contains Text
    public static void assertWithContainsText(String text,String text1 )
    {
        Assert.assertTrue(text.contains(text1));
    }

    public static void assortTextMessage(String expected, By by) {
        String accual = getTextMassage( by );
        Assert.assertEquals( expected, accual );

    }

    //Assert method for assert current url  from ruslin
    public static void assertCurrentURLR (String url){
        Assert.assertTrue(driver.getCurrentUrl().equals(url));
    }
    //24 Assert From Ruslin
    public static void assertByGetText(String expectedResult, By by, String errorMessage) {
        Assert.assertEquals( expectedResult, driver.findElement( by ).getText(), errorMessage );
    }
// 38) take screenshot of current display(full)

//39) Take screenshot of browser

//40).a Take Screenshot
// 41) convert date....




}