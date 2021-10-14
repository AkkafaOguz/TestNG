package tests.yusufHocaProje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Project02 extends TestBase {

    //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    //maximize the web site
    //click on second emoji
    //click all second emoji's element
    //go back parent iframe
    //fill out the form,(Fill the form with the texts you want)
    //click on apply button

    @Test
    public void test () throws InterruptedException {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        //WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        //driver.switchTo().frame("emoojis");     //---> COK YAVAS! **************************************

        //driver.switchTo().frame(1);             //---> COK DAHA HIZLI! *********************************


        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='emojis_frame.html?&smiles=smiles and people&nature=animals and nature&food=food and drink&activities=activities&places=travel and places&objects=objects&symbols=symbols&flags=flags&active=smiles']"));
        driver.switchTo().frame(iframe);          //---> COK DAHA HIZLI! *********************************


        // Hiz icin xpath ya da index kullanmak cok daha avantajli. Direkt olarak id,name locator'lar kullanmak kodun yavas calismasina sebep oluyor.



        WebElement emoji = driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        emoji.click();


        // WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        // webDriverWait.until(ExpectedConditions.elementToBeClickable(emoji)).click();
        // iFrame'e index ya da xpath ile gectikten sonra kod hizlandigi icin bu kodlara gerek kalmadi.



        List<WebElement> emojies = driver.findElements(By.xpath("//div[@id='nature']/div/img"));
        emojies.stream().forEach(t-> t.click());
        driver.switchTo().defaultContent();

        List <WebElement> inputList = driver.findElements(By.xpath("//div[@data-upgraded=',MaterialTextfield']/input"));
        List <String> inputTexts = new ArrayList<>(Arrays.asList("Hello World!", "Joker", "Turkey" ,"Kebab", "Trying to live", "World", "Human" ,"Flag" , "TURK", "", ""));

        for (int i = 0; i < inputList.size(); i++) {

            inputList.get(i).sendKeys((inputTexts.get(i)));
        }

        driver.findElement(By.xpath("//button[@id='send']")).click();

    }
}
