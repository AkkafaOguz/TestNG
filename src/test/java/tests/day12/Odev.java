package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class Odev  extends TestBase {

//2. Bir metod olusturun : isEnabled()
//3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
//4. Textbox’in etkin olmadigini(enabled) dogrulayın
//5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
//6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
//7. Textbox’in etkin oldugunu(enabled) dogrulayın.

    @Test
    public void isEnabled(){

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın

        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(textBox.isEnabled(),"Test for 'isTextBox Enabled' is failed!");

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        softAssert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed(),"Test for 'Visibility of Result Message' is failed!");
        softAssert.assertEquals(driver.findElement(By.xpath("//p[@id='message']")).getText(),("It's enabled!"),"Test for 'Result Message Text' is failed!");

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.

        softAssert.assertTrue(textBox.isEnabled(),"Test for 'isTextBox Enabled' is failed!");
        softAssert.assertAll();
    }
}
