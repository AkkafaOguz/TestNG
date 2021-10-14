package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle extends TestBase {

    //    ● Tests package’inda yeni bir class olusturun: C04_WindowHandle
//● https://the-internet.herokuapp.com/windows adresine gidin.
//● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
//● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
//● Click Here butonuna basın.
//● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
//● Sayfadaki textin “New Window” olduğunu doğrulayın.
//● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.


    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String expecxtedText = "Opening a new window";
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualText,expecxtedText,"Test for 'Page Text' is failed!");
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"Test for 'Page Title' is failed!");


        //1- Window Handle ederken ilk adim 1 sayfa acik iken ilgili sayfanin handle degerini bir container'a atamak.
        System.out.println("Ilk sayfanin handle degeri: " +driver.getWindowHandle());
        String firstPageHandle = driver.getWindowHandle();


        driver.findElement(By.linkText("Click Here")).click();


        //2- Ikici adim iki sayfa acilsiginda her iki sayfanin da handle degerlerini elde tutmak icin
        //bir Set olusturup, getWindowHnadles() methodu ile bu degerleri elde etmek
        Set<String> windowHandleValue = driver.getWindowHandles();
        System.out.println(windowHandleValue);


        //3- Set icersinde birinci sayfanin handle degerine esit olmayan handle degerini bulup bir container'a atamak.


        String secondPageHandle = "";

        for (String w: windowHandleValue) {

            if (!w.equals(firstPageHandle)){
                secondPageHandle=w;
            }
        }

        System.out.println("Second PageHandle: " + secondPageHandle);

        //driver.switchTo().window();
        //swithTo() ile window degistireceksek gidecegimiz window'un windowhandle degerine ihtiyacimiz var.
        String expectedNewTitle = "New Window";
        String actualNewTitle = driver.getTitle();
        softAssert.assertEquals(actualNewTitle,expectedNewTitle,"Test for 'Test for new page title' is failed!");


        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(secondPageHandle);
        // switchTo ile window degistireceksek gidecegimiz window'un windowhandle degerine ihtiyacimiz var...
        String actualNewTitle2= driver.getTitle();
        String expectedNewTitle2="New Window";
        softAssert.assertEquals(actualNewTitle,expectedNewTitle,"yeni sayfanin title'i yanlis");
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement yeniSayfaYaziElementi=driver.findElement(By.tagName("h3"));
        String expectedYaziYeniSayfa="New Window";
        String actualSayfaYaziYeniSayfa=yeniSayfaYaziElementi.getText();
        softAssert.assertEquals(actualSayfaYaziYeniSayfa,expectedYaziYeniSayfa,"yeni sayfadaki yazi beklenenden farkli");
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(firstPageHandle);
        actualTitle=driver.getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"title istenen degerden farkli");

        softAssert.assertAll();




    }

}
