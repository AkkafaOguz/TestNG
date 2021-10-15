package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeybordActions extends TestBase {

//https://www.amazon.com sayfasina gidelim
//Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
//aramanin gerceklestigini test edin

    @Test
    public void test () throws InterruptedException {

        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        Actions actions = new Actions(driver);

        actions.click(searchBox).sendKeys("samsung ").keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).sendKeys("71").sendKeys(Keys.ENTER).perform();

        //Burada clik kullanmak yerine:
        //actions.sendKeys(searchBox,"samsung ").keyDown(Keys.SHIFT)....
        //cift parametreli sendKeys methodu kullanarak searchBox'i target olarak verebiliriz.

        Thread.sleep(3000);

        String expectedTitle="samsung A71";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),"Test for 'Title' is failed!");

    }
}
