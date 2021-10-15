package tests.day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class Odev extends TestBase {

        /*
    ●Bir class olusturun: IframeTest 02
    1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    2) sayfadaki iframe sayısını bulunuz.
    3)ilk iframe'deki (Youtube) play butonuna tıklayınız.
    4)ilk iframe'den çıkıp ana sayfaya dönünüz
    5)ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live selenium
    project.html) tıklayınız
     */

    @Test
    public void test () throws InterruptedException {

//      1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz

        driver.get("http://demo.guru99.com/test/guru99home/");

//      2) sayfadaki iframe sayısını bulunuz.

        List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
        int iFrameCount = iframeList.size();
        System.out.println(iFrameCount);

//      3)ilk iframe'deki (Youtube) play butonuna tıklayınız.

        WebElement firstFrame = driver.findElement(By.xpath("//div[@class='module-surround']/iframe"));
        driver.switchTo().frame(firstFrame);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
        Thread.sleep(3000);

//      4)ilk iframe'den çıkıp ana sayfaya dönünüz

        driver.switchTo().defaultContent();

//      5)ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live selenium project.html) tıklayınız

        WebElement secondFrame = driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
        driver.switchTo().frame(secondFrame);

        String firstPageHandle = driver.getWindowHandle();

        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();

        Set <String> windowHandles = driver.getWindowHandles();

        String secondPageHandle = "";

        secondPageHandle = windowHandles.stream().filter(t-> !t.equals(firstPageHandle)).findFirst().get();

        Thread.sleep(3000);

        driver.switchTo().window(firstPageHandle);
        Thread.sleep(3000);

    }
}
