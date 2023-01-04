package January03_23;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Test01 extends TestBase {

    //1- https://www.amazon.com/ sayfasina gidelim
    //2- arama kutusunu locate edelim
    //3- “Samsung headphones” ile arama yapalim
    //4- Bulunan sonuc sayisini yazdiralim
    //5- Ilk urunu tiklayalim
    //6- bulunan ürünün dolar bazındaki fiyatını Tl ye çevirelim
    //7- Bir önceki sayfaya geri dönelim
    //8- çıkan sonuçların basliklarinı yazdiralim


    @Test
    public void test01() {

        driver.get(https+"amazon"+com);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung headphones"+ Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        driver.findElement(By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[1]")).click();
        String fiyat=driver.findElement(By.xpath("(//*[@class='a-price-whole'])[6]")).getText();
        int fiyatInt=Integer.parseInt(fiyat);
        double dolarKuru=18.72;
        double tlFiyatKarsiligi=fiyatInt*dolarKuru;
        System.out.println("Ürün TL karşılığı fiyatı: " + tlFiyatKarsiligi);
        driver.navigate().back();
        List <WebElement> aramaSonucBasliklari=driver.findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));
        int sayi=1;
        for (WebElement eachASB:aramaSonucBasliklari
             ) {
            System.out.println(sayi +" : " + eachASB.getText());
            sayi++;
        }
    }
}
