package December31_22;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.sql.Array;
import java.util.Arrays;

public class Test01 extends TestBase {

    //2- https://www.google.com/ adresine gidin
    //3- cookies uyarisini kabul ederek kapatin
    //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
    //5- Arama cubuguna “Nutella” yazip aratin
    //6- Bulunan sonuc sayisini yazdirin
    //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    //8- Sayfayi kapatin

    @Test
    public void test01() {

        driver.get("https://www.google.com/");
        String actualSayfaBasligi=driver.getTitle();
        String expectedSayfaBasligi="Google";
        Assert.assertEquals(expectedSayfaBasligi,actualSayfaBasligi);
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella" + Keys.ENTER);
        String sonucYazisi=driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        String[] sonucYazisiArr = sonucYazisi.split(" ");
        //System.out.println(Arrays.toString(sonucYazisiArr));
        String sonucAdediStr = sonucYazisiArr[1].replace(".","");
        System.out.println(sonucAdediStr);

        //int sonucAdediInt = Integer.parseInt(sonucAdediStr);
        double sonucAdediInt=Double.parseDouble(sonucAdediStr);
        System.out.println(sonucAdediInt);
        double expecdetAramaSayisi = 10.000000;

        if (sonucAdediInt > expecdetAramaSayisi) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAİLED");}
    }



}
