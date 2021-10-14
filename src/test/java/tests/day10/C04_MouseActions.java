package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;

public class C04_MouseActions extends TestBase {

    @Test
    public void test() {


//        1- https://demoqa.com/droppable adresine gidelim

        driver.get("https://demoqa.com/droppable");

//        2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
//

        WebElement draggableElement = driver.findElement(By.id("draggable"));
        WebElement dropArea = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggableElement, dropArea).perform();

//
//        3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin


        WebElement droppedText = driver.findElement(By.xpath("(//div[@id='droppable'])[1]/p"));
        String actualDropText = droppedText.getText();
        String expectedDropText = "Dropped!";
        Assert.assertEquals(actualDropText, expectedDropText, "Test for 'Drop Text' is failed!");

    }
}
