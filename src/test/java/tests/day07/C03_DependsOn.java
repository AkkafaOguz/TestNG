package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C03_DependsOn {

//Bir class oluşturun: DependsOnTest
//https://www.amazon.com/ adresine gidin.
//1. Test : amazon ana sayfaya gittiginizi test edin
//2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin ve aramanizin gerceklestigini Test edin
//3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $16.83 oldugunu test edin


    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void confirmWebSite(){
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.amazon.com/"),"Test for 'Confirm Website' is failed!");
    }

    @Test (dependsOnMethods = "confirmWebSite")
    public void confirmProduct(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("Nutella"));
    }

    @Test (dependsOnMethods = "confirmProduct")
    public void confirmProductPrice(){
        driver.findElement(By.xpath("//img[@alt='Nutella Chocolate Hazelnut Spread, Perfect Topping for Halloween Treats, 35.2 Oz Jar']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='a-size-base a-color-price']")).getText().equals("$16.83"),"Test for 'Product Price' is failed!");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }



}
