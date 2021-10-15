package tests.yusufHocaProje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Project03 extends TestBase {

//    Go to http://demo.guru99.com/test/drag_drop.html url
//    Drag and drop the BANK button to the Account section in DEBIT SIDE
//    Drag and drop the SALES button to the Account section in CREDIT SIDE
//    Drag and drop the 5000 button to the Amount section in DEBIT SIDE
//    Drag and drop the second 5000 button to the Amount section in CREDIT SIDE


    @Test
    public void test () throws InterruptedException {

        //    Go to http://demo.guru99.com/test/drag_drop.html

        driver.get("http://demo.guru99.com/test/drag_drop.html");


        WebElement debitSideAccount = driver.findElement(By.xpath("//ol[@class='field14 ui-droppable ui-sortable']"));
        WebElement debitSideAmount = driver.findElement(By.xpath("(//ol[@class='field13 ui-droppable ui-sortable'])[1]"));
        WebElement creditSideAccount = driver.findElement(By.xpath("//ol[@class='field15 ui-droppable ui-sortable']"));
        WebElement creditSideAmount = driver.findElement(By.xpath("(//ol[@class='field13 ui-droppable ui-sortable'])[2]"));


        //    Drag and drop the BANK button to the Account section in DEBIT SIDE

        WebElement bankButton = driver.findElement(By.id("credit2"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(bankButton,debitSideAccount).perform();

        //    Drag and drop the SALES button to the Account section in CREDIT SIDE

        WebElement salesButton = driver.findElement(By.id("credit1"));

        actions.dragAndDrop(salesButton,creditSideAccount).perform();

        //    Drag and drop the 5000 button to the Amount section in DEBIT SIDE

        WebElement fiveThousandButton = driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));

        actions.dragAndDrop(fiveThousandButton,debitSideAmount).perform();

        //    Drag and drop the second 5000 button to the Amount section in CREDIT SIDE

        WebElement secondFiveThousandButton = driver.findElement(By.xpath("(//li[@id='fourth'])[2]"));

        actions.dragAndDrop(secondFiveThousandButton,creditSideAmount).perform();

    }


}
