package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Homework01 {

//1. http://zero.webappsecurity.com/ Adresine gidin
//2. Sign in butonuna basin
//3. Login kutusuna “username” yazin
//4. Password kutusuna “password.” yazin
//5. Sign in tusuna basin
//6. Pay Bills sayfasina gidin
//7. “Purchase Foreign Currency” tusuna basin
//8. “Currency” drop down menusunden Eurozone’u secin
//9. “amount” kutusuna bir sayi girin
//10. “US Dollars” in secilmedigini test edin
//11. “Selected currency” butonunu secin
//12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
//13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin

    WebDriver driver;

    // *********************************************************
    // SoftAssert softAssert = new SoftAssert();
    // --> SoftAssert'i bu sekilde class level'da olusturmak saglikli degil. Method'lar bagimsiz olsalar da, herhangi bir methodda
    // failed bir assertion olmasi durumunda method'un sonundaki AssertAll() methodu SoftAssertion'in ortak kullanildigi  diger metholarin calismasina engel oluyor.
    // Her mothodun 'new' keyword ile kendine ait yeni bir SoftAssertion olusturmasi saglikli bir yontem.
    // *********************************************************


    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void websiteTest(){
        driver.get("http://zero.webappsecurity.com/");
        Assert.assertTrue(driver.getCurrentUrl().contains("zero.webappsecurity"),"Test for 'Web Site' is failed!");
    }


    @Test (dependsOnMethods = "websiteTest")
    public void signInTest () {
        driver.findElement(By.id("signin_button")).click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.getCurrentUrl().contains("login"),"Test for 'Login Page' is failed!");
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")). sendKeys("password");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        softAssert.assertTrue(driver.getCurrentUrl().contains("account"),"Test for 'Login' is failed!");
        softAssert.assertAll();
    }

    @Test (dependsOnMethods = "signInTest")
    public void payBillsTest(){
        driver.findElement(By.linkText("Pay Bills")).click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.getCurrentUrl().contains("pay-bills"),"Test for 'Pay Bills Page' is failed!");
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        softAssert.assertTrue(driver.findElement(By.xpath("//div[@id='ui-tabs-3']/h2")).getText().contains("Purchase foreign currency"),"Test for 'Purchase Foreign Currency Link' is failed!");
        WebElement currencyOptions = driver.findElement(By.id("pc_currency"));
        Select select = new Select(currencyOptions);
        select.selectByValue("EUR");
        softAssert.assertTrue(select.getFirstSelectedOption().getText().contains("Eurozone"),"Test for 'Eurozone Selection' is failed!");
        driver.findElement(By.id("pc_amount")).sendKeys("100");
        softAssert.assertFalse(driver.findElement(By.id("pc_inDollars_true")).isSelected(),"Test for 'Dolar Selection' is failed!");
        driver.findElement(By.id("pc_inDollars_false")).click();
        softAssert.assertTrue(driver.findElement(By.id("pc_inDollars_false")).isSelected(),"Test for 'Selected Currency Selection' is failed!");
        driver.findElement(By.id("pc_calculate_costs")).click();
        softAssert.assertTrue(driver.findElement(By.id("pc_conversion_amount")).isDisplayed(),"Test for 'Calculate Costs' is failed!");
        driver.findElement(By.id("purchase_cash")).click();
        softAssert.assertTrue(driver.findElement(By.id("alert_content")).isDisplayed(),"Test for 'Allert Content' is failed! ");
        softAssert.assertEquals(driver.findElement(By.id("alert_content")).getText(), ("Foreign currency cash was successfully purchased."),"Test for 'Allert Content Text' is failed!");
        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
