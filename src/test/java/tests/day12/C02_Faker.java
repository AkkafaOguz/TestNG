package tests.day12;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {

// "https://facebook.com"  Adresine gidin
//"create new account"  butonuna basin
//"firstName" giris kutusuna bir isim yazin
//"surname" giris kutusuna bir soyisim yazin
//"email" giris kutusuna bir email yazin
//"email" onay kutusuna emaili tekrar yazin
//Bir sifre girin
//Tarih icin gun secin
//Tarih icin ay secin
//Tarih icin yil secin
//Cinsiyeti secin
//Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
//Sayfayi kapatin

    @Test
    public void test() {


        driver.get("https://facebook.com");
        driver.findElement(By.xpath("(//a[contains(@id,'u_0')])[3]")).click();

        Actions actions = new Actions(driver);

        Faker faker = new Faker();
        String email = faker.internet().emailAddress();

        actions.sendKeys(driver.findElement(By.name("firstname")),faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB)
                .sendKeys("12345a!").sendKeys(Keys.TAB).sendKeys(Keys.TAB);


    }
}
