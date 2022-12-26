package December26_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test03 {

    //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin
    //(title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi
    //yazdirin.
    //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa
    //“actual” URL’i yazdirin.
    //4.https://www.walmart.com/ sayfasina gidin.
    //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
    //6. Tekrar “facebook” sayfasina donun
    //7. Sayfayi yenileyin
    //8. Sayfayi tam sayfa (maximize) yapin
    //9.Browser’i kapatin

    @Test
    public void test01() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/");
        String actualBaslik= driver.getTitle();
        String expectedBaslik = "Facebook - Giriş Yap veya Kaydol";
        Assert.assertEquals(expectedBaslik,actualBaslik);
        System.out.println(actualBaslik);
        Thread.sleep(3000);
        driver.get("https://www.walmart.com/");
        String actualBaslik2= driver.getTitle();
        String baslik2 = "walmart";
        driver.navigate().back();
        driver.navigate().refresh();
        driver.close();







    }



}
