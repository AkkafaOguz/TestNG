package tests.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;
import java.security.Key;
import java.util.List;

public class TechProInsta extends TestBase {

    @Test
    public void gmail () throws InterruptedException {

        driver.get("https://www.instagram.com/");
        Thread.sleep(500);
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(By.xpath("(//input[@class='_2hvTZ pexuQ zyHYP'])[1]")),"id").sendKeys(Keys.TAB).sendKeys("password").perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(500);
        driver.findElement(By.className("s4Iyt")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='aOOlW   HoLwm ']")).click();
        Thread.sleep(500);
        actions.click(driver.findElement(By.xpath("//div[@class='LWmhU _0aCwM']"))).sendKeys("techproeducation1").sendKeys(Keys.ENTER).sendKeys(Keys.ENTER).perform();

        Thread.sleep(500);
        List<WebElement> posts = driver.findElements(By.xpath("//div[@class='v1Nh3 kIKUG  _bz0w']"));
        posts.get(0).click();
        Thread.sleep(500);
        for (int i = 0; i < posts.size()-1; i++) {
            driver.findElement(By.xpath("//span[@class='fr66n']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//textarea[@class='Ypffh']")).sendKeys("Well done!");
            Thread.sleep(500);
            driver.findElement(By.xpath("//a[@class=' _65Bje    coreSpriteRightPaginationArrow']")).click();
            Thread.sleep(500);
        }
        driver.findElement(By.xpath("(//img[@class='_6q-tv'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@aria-labelledby='f1787c855d8f78 f2c8ce324533c74 f39eba8a83e43f']")).click();

        Thread.sleep(5000);



    }
}
