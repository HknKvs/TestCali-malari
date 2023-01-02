package January02_23;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Test01 extends TestBase {

    // https://www.kiwi.com sayfasina gidin
    // Cookies i reddedin
    // Sayfa basliginin "kiwi" icerdigini test edin
    // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
    // ///////Sectiginiz dil ve para birimini dogrulayin
    // Ucus secenegi olarak tek yon secelim
    // Kalkis ve varis boxlarini temizleyerek kalkis ve varis şehrini kendimiz belirleyelim
    // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
    // Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
    // Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim

    @Test
    public void test01() {

        driver.get(https+"kiwi"+com);
        ReusableMethods.beklemeModu(2);
        driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
        ReusableMethods.beklemeModu(2);
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
        ReusableMethods.beklemeModu(2);
        Assert.assertTrue(driver.getTitle().contains("Kiwi"));
        driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1r81o9a-0 ZYrQU'])[7]")).click();
        ReusableMethods.beklemeModu(2);
        WebElement dil=driver.findElement(By.xpath("//select[@class='Select__StyledSelect-sc-19y5dzg-1 jFhPRO']"));
        dil.sendKeys("Türkçe" + Keys.TAB);
        ReusableMethods.beklemeModu(2);
        WebElement paraBirimi=driver.findElement(By.xpath("//select[@class='Select__StyledSelect-sc-19y5dzg-1 gCMhzx']"));
        paraBirimi.sendKeys("Turkish" + Keys.TAB);
        ReusableMethods.beklemeModu(2);
        driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1r81o9a-0 ULnUg'])[23]")).click();
        ReusableMethods.beklemeModu(2);
        driver.findElement(By.xpath("(//div[@class='ButtonWrapsstyled__ButtonTabletWrap-sc-zf781k-0 jRIGJM'])[1]")).click();
        ReusableMethods.beklemeModu(2);
        driver.findElement(By.xpath("(//p[@data-test='ModePopup-iconDone'])[2]")).click();
        ReusableMethods.beklemeModu(2);
        driver.findElement(By.xpath("//*[@class='Icon__StyledIcon-sc-1det6wr-0 hRQtyS closeIcon']")).click();
        ReusableMethods.beklemeModu(2);
        WebElement almanya=driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[1]"));
        almanya.sendKeys("Almanya" + Keys.ENTER);
        almanya.click();
        WebElement fransa=driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[2]"));
        fransa.sendKeys("Fransa"+Keys.ENTER);
        fransa.click();
        driver.findElement(By.xpath("//input[@name='search-outboundDate']")).click();
        driver.findElement(By.xpath("(//div[@class='CalendarDaystyled__DateContentWrapper-sc-17hkeg7-10 bqTTgI'])[46]")).click();
        driver.findElement(By.xpath("//button[@class='ButtonPrimitive__StyledButtonPrimitive-sc-1lbd19y-0 qZxcS']")).click();
        driver.findElement(By.xpath("//*[@class='Icon__StyledIcon-sc-1det6wr-0 kauSOB']")).click();
        driver.findElement(By.xpath("//a[@class='ButtonPrimitive__StyledButtonPrimitive-sc-1lbd19y-0 fHJoSR']")).click();
        driver.findElement(By.xpath("(//*[@class='Icon__StyledIcon-sc-1det6wr-0 hRQtyS'])[5]")).click();
        driver.findElement(By.xpath("(//div[@class='Radio__IconContainer-sc-crlwn1-1 ixtoRa'])[1]")).click();
        driver.findElement(By.xpath("(//*[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1r81o9a-0 ZYrQU'])[21]")).click();
        driver.findElement(By.xpath("//p[@class='Text__StyledText-sc-13j9opf-0 jVyVvc']")).click();
        List<WebElement> fiyatListesi=driver.findElements(By.xpath("(//span[@class=' length-8'])"));
        for (WebElement eachEnDusuk:fiyatListesi
             ) {
            String enDusukFiyatListesi=eachEnDusuk.getText().replaceAll(" TL","").replaceAll("\\.","");
            int fiyatListesiInt=Integer.parseInt(enDusukFiyatListesi);
            List <Integer> enDusukListe;
            if (fiyatListesiInt<5000) {
                enDusukListe= Collections.singletonList(fiyatListesiInt);
                System.out.println(enDusukListe);
            }
        }
    }
}
