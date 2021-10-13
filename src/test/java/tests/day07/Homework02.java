package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homework02 {

//https://www.amazon.com/ adresine gidin.
//- Test 1
//Arama kutusunun yanindaki kategori menusundeki kategori
//sayisinin 45 oldugunu test edin
//-Test 2
//1. Kategori menusunden Books secenegini secin
//2. Arama kutusuna Java yazin ve aratin
//3. Bulunan sonuc sayisini yazdirin
//4. Sonucun Java kelimesini icerdigini test edin

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test01 () {
        WebElement optionsDropDown =  driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(optionsDropDown);
        List <WebElement> options = select.getOptions();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(options.size(), 45, "Test for 'Option Number' is faield!");

        select.selectByValue("search-alias=stripbooks-intl-ship");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//div[@class='sg-col-14-of-20 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(result.getText());
        softAssert.assertTrue(result.getText().contains("Java"));
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
