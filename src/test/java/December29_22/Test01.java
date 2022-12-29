package December29_22;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class Test01 extends TestBase {

    // https://the-internet.herokuapp.com/iframe adresine gidin
    // elemental selenium linkini tiklayin
    // yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
    // ilk sayfaya geri donup sayfadaki yazinin
    // "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin

    @Test
    public void test01() {

        driver.get("https://the-internet.herokuapp.com/iframe");
        String ilkHandleDegeri= driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        ReusableMethods.beklemeModu(3);
        Set <String> ikiSayfaninHandlesDegerleri= driver.getWindowHandles();
        String ikinciSayfaHandleDegeri=null;
        for (String eachWHD:ikiSayfaninHandlesDegerleri
             ) {
            if (!eachWHD.equals(ilkHandleDegeri)) {
                ikinciSayfaHandleDegeri=eachWHD;
            }
        }
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        ReusableMethods.beklemeModu(3);
        String expectedYazi="Elemental Selenium";
        String actualYazi=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        ReusableMethods.beklemeModu(3);
        driver.switchTo().window(ilkHandleDegeri);
        String expectedIlkSayfaYazi="An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualIlkSayfaYazi=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedIlkSayfaYazi,actualIlkSayfaYazi);
        ReusableMethods.beklemeModu(3);

    }



}
