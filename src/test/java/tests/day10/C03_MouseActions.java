package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions extends TestBase {

//1- Yeni bir class olusturalim: C03_MouseActions1
//2- https://the-internet.herokuapp.com/context_menu sitesine gidelim

    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");


        //3- Cizili alan uzerinde sag click yapalim

        Actions actions = new Actions(driver);
        WebElement area = driver.findElement(By.id("hot-spot"));
        actions.contextClick(area).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugun test edelim.

        String expectedAllertText = "You selected a context menu";
        String actualAllertText = driver.switchTo().alert().getText();
        Assert.assertEquals(actualAllertText, expectedAllertText, "Test for 'Allert Text' is failed!");

        //5- Tamam diyerek alert’I kapatalim

        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        actions.click().perform();
        Thread.sleep(1000);

        //6- Elemental Selenium linkine tiklayalim

        String firstPageHandle = driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        String secondPageHandle = "";
        for (String w : allWindowHandles) {
            if (!w.equals(firstPageHandle)) {
                secondPageHandle = w;
            }
        }

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        driver.switchTo().window(secondPageHandle);
        String expectedH1 = "Elemental Selenium";
        String actualH1 = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(actualH1, expectedH1, "Test for ''h1 Tag Text' is failed!");


    }


}
