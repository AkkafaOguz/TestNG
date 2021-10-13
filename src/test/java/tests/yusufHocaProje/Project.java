package tests.yusufHocaProje;

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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Project {

    /**
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     * Choose price low to high
     * Verify item prices are sorted from low to high
     */

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginTest(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test (dependsOnMethods = "loginTest" )
    public void filterTest(){
        WebElement filter = driver.findElement(By.className("product_sort_container"));
        Select select =  new Select(filter);
        select.selectByValue("lohi");

        //1.Way to confirm filtering:

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(By.className("active_option")).getText(), "PRICE (LOW TO HIGH)", "Test for 'Filtering Option' is failed!");

        //2.Way to confirm filtering:

        List<WebElement> productsPrice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List <String> strProductsPrice = new ArrayList<>();
        productsPrice.stream().forEach(t-> strProductsPrice.add(t.getText()));
        List <Double> productsPriceDouble = new ArrayList<>();
        strProductsPrice.stream().forEach(t-> productsPriceDouble.add(Double.parseDouble(t.replace("$",""))));
        List <Double> confirmFiltering = new ArrayList<>();
        confirmFiltering.addAll(productsPriceDouble);
        Collections.sort(confirmFiltering);
        Assert.assertEquals(productsPriceDouble,confirmFiltering,"Test for 'Filtering Option' is failed!");

        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }


}
