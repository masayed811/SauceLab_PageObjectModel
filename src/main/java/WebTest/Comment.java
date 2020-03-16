package WebTest;

import org.openqa.selenium.By;

public class Comment extends Utils {

    private  By _title= By.xpath("//input[@id=\"AddNewComment_CommentTitle\"]");
    private  By _commentWrite=By.xpath( "//textarea[@id=\"AddNewComment_CommentText\"]" );
    private  By _newComment = By.xpath( "//input[@class=\"button-1 news-item-add-comment-button\"]" );
    private  By _asserComment =By.xpath( "//div[3]/div[2]/div/p[contains(@class,\"comment-text\")]" );




    public void userIsOnNewReleasePageForComment(){
        // user is on nopCommerce new release page
        assertCurrentURLR( "https://demo.nopcommerce.com/nopcommerce-new-release" );
        // enter the title
        enterText( _title,"This From SSSSSS" );

        // enter comments
        enterText( _commentWrite,"Amar sonar bangla Ami Tomay Valobasi" );

        //click on new comment button
        clickElement( _newComment );


        //asert comment is on the page
        clickElement( _asserComment );
        System.out.println("comment is :-Amar sonar bangla Ami Tomay Valobasi");
    }







}

