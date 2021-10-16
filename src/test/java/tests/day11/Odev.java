package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Odev extends TestBase {

//1- "http://webdriveruniversity.com/Actions" sayfasina gidin
//2- Hover over Me First" kutusunun ustune gelin
//3- Link 1" e tiklayin
//4- Popup mesajini yazdirin
//5- Popup'i tamam diyerek kapatin
//6- “Click and hold" kutusuna basili tutun
//7-“Click and hold" kutusunda cikan yaziyi yazdirin
//8- “Double click me" butonunu cift tiklayin


    @Test
    public void test () throws InterruptedException {

        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin

        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin

        WebElement firstElement = driver.findElement(By.xpath("//*[.='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstElement).perform();
        Thread.sleep(1000);

        //3- Link 1" e tiklayin

        driver.findElement(By.linkText("Link 1")).click();
        Thread.sleep(1000);

        //4- Popup mesajini yazdirin

        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);

        //5- Popup'i tamam diyerek kapatin

        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        //6- “Click and hold" kutusuna basili tutun

        WebElement holdBox = driver.findElement(By.id("click-box"));
        actions.clickAndHold(holdBox).perform();
        Thread.sleep(1000);

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin

        System.out.println(holdBox.getText());

        //8- “Double click me" butonunu cift tiklayin

        WebElement doubleClickBox = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickBox).perform();
        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='div-double-click double']")).isDisplayed(),"Test for 'Double Click' is failed!");

    }
}
