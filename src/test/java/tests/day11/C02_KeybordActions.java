package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_KeybordActions extends TestBase {

//https://html.com/tags/iframe/ sayfasina gidelim
//video’yu gorecek kadar asagi inin
//videoyu izlemek icin Play tusuna basin
//videoyu calistirdiginizi test edin


    @Test
    public void test () throws InterruptedException {
        driver.get("https://html.com/tags/iframe/");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);

        WebElement youtubeIframe = driver.findElement(By.className("lazy-loaded"));
        driver.switchTo().frame(youtubeIframe);
        WebElement playButton = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        playButton.click();

        Thread.sleep(2000);

        Assert.assertFalse(playButton.isDisplayed());

        Thread.sleep(2000);
    }
}
