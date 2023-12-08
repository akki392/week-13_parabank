package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials()  {
        sendTextToElement(By.name("username"),"akash3592");
        sendTextToElement(By.name("password"),"akash@1234");
        clickOnElement(By.xpath("//input[@value='Log In']"));
        String expectedMessage ="Accounts Overview";
        WebElement actualTextFromElement= driver.findElement(By.xpath("//a[contains(text(),'Accounts Overview')]"));
        String actualMessage=actualTextFromElement.getText();
        Assert.assertEquals("Accounts Overview",expectedMessage,actualMessage);
    }
    @Test
    public void verifyTheErrorMessage(){
        sendTextToElement(By.name("username"),"akash392");
        sendTextToElement(By.name("password"),"akash1234");
        clickOnElement(By.xpath("//input[@value='Log In']"));

    }
    @Test
    public void userShouldLogOutSuccessfully(){
        sendTextToElement(By.name("username"),"akash3592");
        sendTextToElement(By.name("password"),"akash@1234");
        clickOnElement(By.xpath("//input[@value='Log In']"));
        clickOnElement(By.xpath("//a[text()='Log Out']"));
        assertVerifyText(By.xpath("//h2[contains(text(),'Customer Login')]"),"Customer Login");
    }
    @After
    public void endTest(){
        closeBrowser();
    }
}
