package tests.day11;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test(){

      System.out.println(System.getProperty("user.home"));

//    C:\Users\90534\OneDrive\Masaüstü\picture.jpg

      String filePath = System.getProperty("user.home") + "\\OneDrive\\Masaüstü\\picture.jpg" ;

      System.out.println("File path: " + filePath);

      System.out.println(Files.exists(Paths.get(filePath)));

      Assert.assertTrue(Files.exists (Paths.get (filePath)));

      System.out.println(System.getProperty("user.dir"));

      // System.getProperty("user.dir") -> Icinde bulundugum dosyanin konumu verir.
    }
}
