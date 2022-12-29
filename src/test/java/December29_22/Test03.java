package December29_22;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class Test03 extends TestBase {

    // https://www.trendyol.com adresine gidin
    // cerezleri kabul et
    // Nutella aratın ve nutella yazdiğini dogrulayin
    // ilk ürünü tıklayin
    // daha sonra ürünün göründüğünü test edin
    // sepete gönderip sepette oldugunu test edin
    // sonra ilk sayfaya donus yapip anasayfaya tiklayin

    @Test
    public void test01() {

        driver.get("https://www.trendyol.com");
        String ilkSayfaHandle= driver.getWindowHandle();
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        ReusableMethods.beklemeModu(3);
        WebElement aramaKutusu= driver.findElement(By.className("vQI670rJ"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        String expectedAramaSonucu="Nutella";
        String actualAramaSonucu=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedAramaSonucu,actualAramaSonucu);
        driver.findElement(By.xpath("(//span[@class='prdct-desc-cntnr-name hasRatings'])[1]")).click();
        Set<String> ikiSayfaHandleDegerleri=driver.getWindowHandles();
        String ikinciSayfaHandle=null;
        for (String eachWHD:ikiSayfaHandleDegerleri
             ) {
            if (!eachWHD.equals(ikinciSayfaHandle)) {
                ikinciSayfaHandle=eachWHD;
            }
        }
        driver.switchTo().window(ikinciSayfaHandle);
        String expectedIlkUrun="Nutella";
        String actualIlkUrun=driver.findElement(By.xpath("//a[text()='Nutella']")).getText();
        Assert.assertEquals(expectedIlkUrun,actualIlkUrun);
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("//div[text()='Sepete Ekle']")).click();
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("//p[text()='Sepetim']")).click();
        ReusableMethods.beklemeModu(3);
        WebElement sepettekiUrun = driver.findElement(By.xpath("//div[@class='pb-basket-item']"));
        Assert.assertTrue(sepettekiUrun.isDisplayed());
        driver.switchTo().window(ilkSayfaHandle);
        driver.findElement(By.xpath("//a[@id='logo']")).click();

    }
}
