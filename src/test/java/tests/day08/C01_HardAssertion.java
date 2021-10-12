package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_HardAssertion {

// amazon sayfasina gidin
// url'in amazon icerdigini test edin
// title'in amazon icerdigini test edin
// java kelimesi aratin ve listedeki ilk urunun java kelimesi icerdigini test edin


    // HardAssertion'da kod ilk karsilastigi failed'da calismayi durdurur.


    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test () {
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        Assert.assertTrue(driver.getTitle().contains("amazon"));
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java");
        driver.findElement(By.className("nav-search-submit nav-sprite")).click();
        String firstElement = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).getText();
        Assert.assertTrue(firstElement.contains("java"));
    }
}
