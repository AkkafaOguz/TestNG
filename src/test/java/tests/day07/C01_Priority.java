package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//Priorty belirtmez isek priority value default olarak '0' olur.
//1-Priority value'su negatif olanlar value'larina gore siralanarak ilk olarak calisir.
//2-Priority belirtmediklerimiz oncesinde kendi aralarinda alfabetik olarak calisir,
//3-Priority'leri pozitif olanlar value'larina gore siralanarak calisir.


//BeforeMetohd --> Before in JUnit

public class C01_Priority {

    //3 adet test methodu olusturun
    //1. amazon
    //2. techproeducation
    //3. facebook
    //Tittle'lar yazdirilsin

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test (priority = 1)
    public void amazonTest(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }

    @Test (priority = 2)
    public void techProTest(){
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void facebookTest(){
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void googleTest(){
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
