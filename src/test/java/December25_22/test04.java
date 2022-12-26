package December25_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class test04 {


    @Test
    public void setup() throws InterruptedException {

        /*
        SORU:
        1-Web driver ayarlarını yapın
        2-Pencere ekranını tam ekran yapın
        3-Pencere kapanma süresini 10 saniye olarak ayarlayın
        4-Trendyol sayfasına gidin
        5-Kadın kategorisini seçerek "spor ayakkabı arattırın
        6-çıkan sonuç sayfasını yazdırın
        7-Gelen sayfadaki en yükçek fiyatlı ayakkabıyı yazdırın çıkış yapın
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.trendyol.com");
        driver.findElement(By.xpath("(//a[@class='category-header'])[1]")).sendKeys(Keys.ENTER);
        WebElement arama=driver.findElement(By.className("vQI670rJ"));
        arama.sendKeys("spor ayakkabı"+ Keys.ENTER);
        WebElement aramaSonucu=driver.findElement(By.xpath("//div[@class='dscrptn']"));
        System.out.println(aramaSonucu.getText());

        List <WebElement> fiyatListesi = driver.findElements(By.className("prc-box-dscntd"));
        int virgulSilme=0;
        int noktaSilme=0;
        int fiyatListesiInt=0;
        int enYuksekFiyat=0;
        String yeniKelime = null;

        /*for (WebElement each: fiyatListesi
             ) {
            System.out.println(each.getText().replaceAll("TL", "").replaceAll(" ", ""));}*/

        for (WebElement each:fiyatListesi
             ) {

            yeniKelime = each.getText().replaceAll("TL", "").replaceAll(" ", "");

            virgulSilme = yeniKelime.indexOf(',');
            if (virgulSilme != -1) {
                yeniKelime = yeniKelime.substring(0, virgulSilme);
                noktaSilme = yeniKelime.indexOf('.');
                if (noktaSilme != -1) {
                    yeniKelime = yeniKelime.substring(0, noktaSilme);}
                fiyatListesiInt = Integer.parseInt(yeniKelime);
                if (fiyatListesiInt>enYuksekFiyat) {

                    enYuksekFiyat=fiyatListesiInt;
                }
            }
            }
            System.out.println("1.Sayfadaki en yüksek fiyat = "+ enYuksekFiyat + " TL.dir");

            Thread.sleep(2000);
            driver.close();
        }



    }






