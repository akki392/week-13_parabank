package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl ="https://parabank.parasoft.com/parabank/index.htm/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        clickOnElement(By.xpath("//a[text()='Register']"));
        String expectedMessage = "Signing up is easy!";
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Signing up is easy!']"));
        Assert.assertEquals("No such message displayed :",expectedMessage, actualMessage);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        clickOnElement(By.xpath("//a[text()='Register']"));
        sendTextToElement(By.name("customer.firstName"),"Akash");
        sendTextToElement(By.name("customer.lastName"),"Dalwadi");
        sendTextToElement(By.id("customer.address.street"),"84,Northwick Avenue");
        sendTextToElement(By.id("customer.address.city"),"Harrow");
        sendTextToElement(By.id("customer.address.state"),"United Kingdom");
        sendTextToElement(By.id("customer.address.zipCode"),"HA30AT");
        sendTextToElement(By.id("customer.phoneNumber"),"07545407175");
        sendTextToElement(By.id("customer.ssn"),"995684231");
        sendTextToElement(By.id("customer.username"),"akash3592");
        sendTextToElement(By.id("customer.password"),"akash@1234");
        sendTextToElement(By.id("repeatedPassword"),"akash@1234");
        clickOnElement(By.xpath("//input[@value='Register']"));
        WebElement actualTextFromElement = driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"));
        String actualMessage =actualTextFromElement.getText();
        Assert.assertEquals("no message found",actualMessage);
    }
    @After
    public void endTest(){
        closeBrowser();
    }

}
