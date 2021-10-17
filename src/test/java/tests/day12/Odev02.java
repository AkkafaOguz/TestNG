package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class Odev02 extends TestBase {

//2. Bir metod olusturun : enableTest()
//3. https://demoqa.com/dynamic-properties adresine gidin.
//4. Will enable 5 seconds’in etkin olmadigini(enabled) test edin
//5. Will enable 5 seconds etkin oluncaya kadar bekleyin ve enabled oldugunu test edin
//6. Bir metod olusturun : visibleTest()
//7. Ayni sayfaya tekrar gidin, Visible After 5 Seconds butonunun gorunmesini bekleyin,
//ve gorunur oldugunu test edin



    @Test (priority = 1)
    public void enableTest(){

        driver.get("https://demoqa.com/dynamic-properties");
        WebElement willEnableButton = driver.findElement(By.xpath("//button[@id='enableAfter']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(willEnableButton.isEnabled(),"Test for 'Enable After Button Should Not Be Enable' is failed!");
        WebDriverWait wait = new WebDriverWait(driver , 20);
        wait.until(ExpectedConditions.elementToBeClickable(willEnableButton));
        softAssert.assertTrue(willEnableButton.isEnabled(),"Test for 'Enable After Button Should Be Enable' is failed!");
        softAssert.assertAll();
    }

    @Test (priority = 2)
    public void visibleTest(){

        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver , 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='visibleAfter']")));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.xpath("//button[@id='visibleAfter']")).isEnabled(),"Test for 'Visible After Button Should Be Visible' is failed!");
        softAssert.assertAll();

    }

}
