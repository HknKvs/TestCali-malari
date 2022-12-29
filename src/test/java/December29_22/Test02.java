package December29_22;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class Test02 extends TestBase {

    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

    @Test
    public void test01() {

        driver.get("https://the-internet.herokuapp.com/windows");
        String expectedSayfaYazisi = "Opening a new window";
        String actualSayfaYazisi = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedSayfaYazisi, actualSayfaYazisi);
        ReusableMethods.beklemeModu(3);
        String expectedSayfaTitle = "The Internet";
        String actualSayfaTitle = driver.getTitle();
        String ilkSayfaHandleDegeri = driver.getWindowHandle();
        Assert.assertEquals(expectedSayfaTitle, actualSayfaTitle);
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.linkText("Click Here")).click();
        ReusableMethods.beklemeModu(3);
        Set<String> tumWindowHandleDegerleri = driver.getWindowHandles();
        String ikinciSayfaWHD = null;
        for (String eachWHD : tumWindowHandleDegerleri
        ) {
            if (!eachWHD.equals(ilkSayfaHandleDegeri)) {
                ikinciSayfaWHD = eachWHD;
            }
        }
        driver.switchTo().window(ikinciSayfaWHD);

        String expectedYeniSayfaTitle = "New Window";
        String actualYeniSayfaTitle = driver.getTitle();
        Assert.assertEquals(expectedYeniSayfaTitle, actualYeniSayfaTitle);
        String expectedYeniSayfaYazi = "New Window";
        String actualYeniSayfaYazi = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedYeniSayfaYazi, actualYeniSayfaYazi);
        ReusableMethods.beklemeModu(3);
        driver.switchTo().window(ilkSayfaHandleDegeri);
        expectedSayfaTitle = "The Internet";
        actualSayfaTitle = driver.getTitle();
        Assert.assertEquals(expectedSayfaTitle, actualSayfaTitle);
        ReusableMethods.beklemeModu(3);

    }

    }

