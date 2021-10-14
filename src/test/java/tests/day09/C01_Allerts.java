package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class C01_Allerts {

//● Bir class olusturun: C01_Alerts
//● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
//● Bir metod olusturun: acceptAlert
//○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının       “You successfully clicked an alert” oldugunu test edin.
//● Bir metod olusturun: dismissAlert
//○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının    “successfuly” icermedigini test edin.
//● Bir metod olusturun: sendKeysAlert
//○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna     tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.


    WebDriver driver;


    //**********************************************
    // SoftAssert softAssert = new SoftAssert();
    // Bu sekilde olusturmak saglikli degil, methodlari tek tek calistirmamizin onune gecer.
    //**********************************************



    //**********************************************
    // Tekrar tekrar Assert class adini kullanmadan method'larini kullanmak icin
    // "import static org.testng.Assert.*;"
    // yaparak class'taki methodlari import ettik.
    //**********************************************



    //**********************************************
    // 2. Way to handle allert
    // WebDriverWait w = new WebDriverWait(driver, 10);
    // Alert alert = w.until(ExpectedConditions.alertIsPresent());
    // Thread.sleep(2000);
    // alert.accept();
    //**********************************************



    @BeforeClass
    public void setUp () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void acceptAllert(){

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        String expectedResultMessage = "You successfully clicked an alert";
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),expectedResultMessage,"Test for 'Accept Allert' is failed!");

    }

    @Test
    public void dismissAlert () {

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        assertFalse(driver.findElement(By.id("result")).getText().contains("successfuly"),"Test for 'Dissmiss Allert' is failed!");

    }

    @Test
    public void sendKeysAlert () {

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Oguzhan");
        driver.switchTo().alert().accept();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.id("result")).getText().contains("Oguzhan"));
        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
