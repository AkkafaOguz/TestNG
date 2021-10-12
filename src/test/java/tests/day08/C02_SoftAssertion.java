package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_SoftAssertion {

    // 3 steps for Soft Assert:

    // 1- SoftAssert softAssert = new SoftAssert();
    // 2- softAssert.assertTrue(driver.getCurrentUrl().contains("amazon"), "Test for 'URL' is failed!");
    // 3- softAssert.assertAll();

    // Assertions pass olsa da olmasa da assertAll'a kadar olan tum satirlar calisir
    // Testlerden bir tanesi dahi failed olursa kod assertAll'a kadar calismaya devam eder. assertAll sonrasindaki kodlar calismaz.

    //Verify --> SoftAssert


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
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://www.amazon.com");
        softAssert.assertTrue(driver.getCurrentUrl().contains("amazon"), "Test for 'URL' is failed!");
        softAssert.assertTrue(driver.getTitle().contains("amazon"),"Test for 'Title' is failed!");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java" + Keys.ENTER);
        String firstElement = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).getText();
        softAssert.assertTrue(firstElement.contains("java"),"Test for 'First Element's Text Part' is failed!");

        System.out.println("Herhangi bir sart sonucu failed olsa dahi kod buraya kadar calismaya devam eder.");
        softAssert.assertAll();
        System.out.println("Eger herhangi bir failed sart varsa, bu kod calismaz.");
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }

}
