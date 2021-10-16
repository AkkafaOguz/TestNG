package tests.yusufHocaProje;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Project04 extends TestBase {


    /*

    go to url :http://demo.automationtesting.in/Alerts.html
    click  "Alert with OK" and click 'click the button to display an alert box:'
    accept Alert(I am an alert box!) and print alert on console
    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    cancel Alert  (Press a Button !)
    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    and then sendKeys 'TechProEducation' (Please enter your name)
    finally print on console this mesaaje "Hello TechproEducation How are you today"

     */

    @Test
    public void test () {

        //go to url :http://demo.automationtesting.in/Alerts.html

        driver.get("http://demo.automationtesting.in/Alerts.html");

        //click  "Alert with OK" and click 'click the button to display an alert box:'

        driver.findElement(By.linkText("Alert with OK")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

        //accept Alert(I am an alert box!) and print alert on console

        String allertText = driver.switchTo().alert().getText();
        System.out.println(allertText);
        driver.switchTo().alert().accept();

        //click "Alert with OK & Cancel" and click 'click the button to display a confirm box'

        driver.findElement(By.linkText("Alert with OK & Cancel")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        driver.switchTo().alert().dismiss();

        //click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'

        driver.findElement(By.linkText("Alert with Textbox")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

        //and then sendKeys 'TechProEducation' (Please enter your name)

        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();

        //finally print on console this mesaaje "Hello TechproEducation How are you today"

        System.out.println(driver.findElement(By.id("demo1")).getText());



    }

}
