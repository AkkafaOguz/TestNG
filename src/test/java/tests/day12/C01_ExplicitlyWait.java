package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C01_ExplicitlyWait extends TestBase {

//1. Bir class olusturun : C01_WaitTest
//2. Iki tane metod olusturun : implicitWait() , explicitWait()
//Iki metod icin de asagidaki adimlari test edin.
//3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
//4. Remove butonuna basin.
//5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
//6. Add buttonuna basin
//7. It’s back mesajinin gorundugunu test edin

    @Test
    public void implicitWaitTest () throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        SoftAssert softAssert = new SoftAssert();
//      WebElement resultText = driver.findElement(By.id("message"));
//      bu sekilde yaparsam ve eger element yoksa kodum durur.
        softAssert.assertTrue(driver.findElement(By.id("message")).isDisplayed(),"Test for 'Result Element' is failed!");
        softAssert.assertEquals(driver.findElement(By.id("message")).getText(),"It's gone!","Test for 'Result Element Text' is failed!");

        driver.findElement(By.xpath("//button[.='Add']")).click();

        softAssert.assertTrue(driver.findElement(By.id("message")).isDisplayed(),"Test for 'Result Element' is failed!");

        //      resultText = driver.findElement(By.id("message"));
//      text'i degisen elementlerin locate'i sorun olusturabilir. Bunun icin locator'i text() uzerinden almak daha saglikli.

        softAssert.assertEquals(driver.findElement(By.id("message")).getText(),"It's back!","Test for 'Result Element Text' is failed!");
        softAssert.assertAll();
    }

    @Test
    public void explicitWaitTest () {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[.='Remove']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 15);

        WebElement yaziLocateIleBirlikte = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(("message"))));

        Assert.assertTrue(yaziLocateIleBirlikte.isDisplayed());

        //Bu islem tek satida yapilabilir:

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(("message")))).isDisplayed());

        driver.findElement(By.xpath("//button[.='Add']")).click();

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(("message")))).isDisplayed());




    }
}
