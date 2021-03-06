package tests.day09;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C04_WindowHandle extends TestBase {

//    ● Tests package’inda yeni bir class olusturun: C04_WindowHandle
//● https://the-internet.herokuapp.com/windows adresine gidin.
//● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
//● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
//● Click Here butonuna basın.
//● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
//● Sayfadaki textin “New Window” olduğunu doğrulayın.
//● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.


    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String expecxtedText = "Opening a new window";
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualText,expecxtedText,"Test for 'Page Text' is failed!");
        String expectedTitle = "The Internet";
        String acturalTitle = driver.getTitle();
        softAssert.assertEquals(acturalTitle,expectedTitle,"Test for 'Page Title' is failed!");
        driver.findElement(By.linkText("Click Here")).click();

        String expectedNewTitle = "New Window";
        String actualNewTitle = driver.getTitle();
        softAssert.assertEquals(actualNewTitle,expectedNewTitle,"Test for 'Test for new page title' is failed!");
    }



}
