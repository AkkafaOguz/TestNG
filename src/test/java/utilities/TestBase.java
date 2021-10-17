package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {




    // TestBase class'ini istersek abstract class olarak olusturabiliriz.
    // Sart degildir. Bunu yaparak class'dan obje olusturulmasinin onune geceriz.


    // public : herkes ulasabilir
    // protected : ayni package veya child class
    // default ( bir sey yazmayinca da default kabul edilir) : package private
    // private : sadece class icinde kullanabiliriz

    protected WebDriver driver;
    // --> WebDriver accessModifier'i public ya da protedted olmali.
    // Protected tercih edilir.

    @BeforeClass
    public void setUp () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
