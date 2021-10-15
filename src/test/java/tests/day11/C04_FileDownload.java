package tests.day11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {

//Iki tane metod oluşturun : isExist() ve downloadTest()
//downloadTest () metodunun icinde aşağıdaki testi yapalim:
//- https://the-internet.herokuapp.com/download adresine gidelim.
//- code.txt dosyasını indirelim
//Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim




    @Test
    public void downloadTest () throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("logo.png")).click();

        Thread.sleep(2000);
    }

    @Test (dependsOnMethods = "downloadTest")
    public void isExist() {

        String filePath = System.getProperty("user.home")+ "\\Downloads\\logo.jpg";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

    }




}
