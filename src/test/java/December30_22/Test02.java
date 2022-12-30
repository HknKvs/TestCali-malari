package December30_22;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class Test02 extends TestBase {

    //1-https://www.hepsiburada.com gidin
    //2-Çerezleri kabul eden
    //3-"Kitap" kelimesini aratın
    //4-Çıkan sonuçta en çok okunan kitap sekmesini seçin
    //5- Gelen sayfadaki kitapları fiyatlarını listeleyerek 50 TL üzeri olan kitapları bulun.

    @Test
    public void test01() {

        driver.get("https://www.hepsiburada.com");
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        ReusableMethods.beklemeModu(3);
        WebElement aramaKutusu = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        aramaKutusu.sendKeys("Kitap" + Keys.ENTER);
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("//img[@width='432']")).click();
        ReusableMethods.beklemeModu(3);
        List<WebElement> fiyatListesi = driver.findElements(By.className("second-price-area"));
        String fiyatListesiStr;

        for (WebElement eachKL : fiyatListesi
        ) {
            fiyatListesiStr = eachKL.getText();
            fiyatListesiStr = fiyatListesiStr.replaceAll(" ", "").replaceAll("TL", "").replaceAll(",", ".");
            double fiyatListesiDouble = Double.parseDouble(fiyatListesiStr);
            double elliTlUzeriKitapListesi = 0.0;
            if (fiyatListesiDouble > 50) {
                elliTlUzeriKitapListesi = fiyatListesiDouble;
                System.out.println("50 TL üzeri olan Kitap Listesi: " + elliTlUzeriKitapListesi);
            }
        }
    }


}
