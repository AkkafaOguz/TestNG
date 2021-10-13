package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C03_SoftAssert {

//    Yeni bir Class Olusturun : D10_SoftAssertTest
// 1. “http://zero.webappsecurity.com/” Adresine gidin
// 2. Sign in butonuna basin
// 3. Login kutusuna “username” yazin
// 4. Password kutusuna “password.” yazin
// 5. Sign in tusuna basin
// 6. Pay Bills sayfasina gidin
// 7. “Purchase Foreign Currency” tusuna basin
// 8. “Currency” drop down menusunden Eurozone’u secin
// 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
// 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
// "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)",
// "Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

 WebDriver driver;

 @BeforeClass
 public void setUp(){
  WebDriverManager.chromedriver().setup();
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 }

 @Test
 public void test() {
  driver.get("http://zero.webappsecurity.com/");
  driver.findElement(By.id("signin_button")).click();
  driver.findElement(By.id("user_login")).sendKeys("username");
  driver.findElement(By.id("user_password")).sendKeys("password");
  driver.findElement(By.name("submit")).click();
  driver.findElement(By.id("details-button")).click();
  driver.findElement(By.id("proceed-link")).click();
  driver.findElement(By.linkText("Pay Bills")).click();
  driver.findElement(By.linkText("Purchase Foreign Currency")).click();

  WebElement options = driver.findElement(By.id("pc_currency"));
  Select select = new Select(options);
  select.selectByVisibleText("Eurozone (euro)");

  SoftAssert softAssert = new SoftAssert();

  softAssert.assertTrue(select.getFirstSelectedOption().getText().equals("Eurozone (euro)"),"Test for 'Selected Option' is failed!");

  List<WebElement> options1 = select.getOptions();

  List <String> strOptions = new ArrayList<>();

  options1.stream().forEach(t-> strOptions.add(t.getText()));

  List <String> expectedOptions = new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)",
  "Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"));

  softAssert.assertTrue(strOptions.equals(expectedOptions),"Test for 'Options' is failed!");

  softAssert.assertAll();

 }
@AfterClass
 public void tearDown() {
  driver.quit();
}
}
