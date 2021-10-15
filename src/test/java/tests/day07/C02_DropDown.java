package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_DropDown {

//Bir class oluşturun: DropDown
//https://the-internet.herokuapp.com/dropdown adresine gidin.
//1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
//2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
//3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
//4.Tüm dropdown değerleri(value) yazdırın
//5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.


    // *************************************************
    // Dropdown'da getFirstSelectedOption() methodunu kullanirken dikkatli ol. Eger HTML kodu uzerinde "select=selected" attribute ve value'su secilen option kodu icin gozukmuyorsa
    // bu method calismaz. Sectigin option'i dogrulamak icin manuel olarak HTML kodunda secenekler secildiginde dinamik olarak degisen satiri bulup locate ederek sonrasinda bunun uzerinden assertion uygularsin.
    // *************************************************


    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void optionTest(){

        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        //Once secip sonrasinda yazdiriyoruz. Tek satirsa iki islem ayni anda olmuyor.
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        List<WebElement> options = select.getOptions();
        options.stream().forEach(t-> System.out.println(t.getText()));


        System.out.println(options.size()>=4 ? "True" : "False");
        System.out.println("Number of options: " + options.size());

    }

    @AfterClass
    public void tearDown (){
        driver.quit();
    }

}
