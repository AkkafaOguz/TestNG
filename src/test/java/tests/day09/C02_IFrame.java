package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_IFrame {

//● Bir class olusturun: C02_IframeTest
//● https://the-internet.herokuapp.com/iframe adresine gidin.
//● Bir metod olusturun: iframeTest
//○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
//○ Text Box’a “Merhaba Dunya!” yazin.
//○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.



//    ******************************************************************************

//    ● Bir sayfada iframe varsa, Selenium bir iframe içindeki elementleri doğrudan göremez.
//    ● Switching to iframe: iframe gecmenin 3 yolu vardir;
//    ○ index ile :
//       driver.switchTo().frame(index of the iframe); //index start from 0
//    ○ id veya name value ile
//       driver.switchTo().frame("id of the iframe");
//    ○ WebElement ile
//       driver.switchTo().frame(WebElement of the iframe)

//     ******************************************************************************

//   SwitchTo() methodu parametresini olustururken index kullanmak kodun hizli calismasi icin en iyi secenektir.
//   Ancak sayfada birden fazla iFrame var ise index kullanirken dikkat etmek gerekiyor.


    WebDriver driver;

    @BeforeClass
    public void setUp () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void iframeTest() {

        WebElement text = driver.findElement(By.xpath("//div[@class='example']/h3"));
        Assert.assertTrue(text.isDisplayed(), "Test for 'An IFrame containing…. Text' is failed!");
        System.out.println(text.getText());


        //driver.switchTo().frame("mce_0_ifr");  --> Daha yavas
        driver.switchTo().frame(0);


        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']/p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");

        //****************************************************

        // Bir iFrame'e gecis yaptiktan sonra, yeniden anasayfa ile ilgili islem yapmamiz gerekiyorsa, gecis yaptigimizdin iFrame'den tekrar anasayfaya gecis yapmaliyiz.
        // driver.switchTo().parentFrame();
        // Fakat birden fazla ic ice iFrame olma ihtimaline karsi,
        // driver.switchTo().defaultContent();
        // kullaniriz ve direkt olarak anasayfa'ya donus saglariz.

        //****************************************************


        //driver.switchTo().parentFrame(); --> nested iFrame ihtimali dolayisiyla guvenli degil. Gerektiginde kullanilabilir.
        driver.switchTo().defaultContent();

        WebElement elementLink = driver.findElement(By.linkText("Elemental Selenium"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(elementLink.isDisplayed(),"Test for 'Link for Iframe' is failed!");
        System.out.println(elementLink.getText());

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
