package December28_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Test01 {

    //1- Bir test class’i olusturun ilgili ayarlari yapin
    //2- https://www.automationexercise.com/ adresine gidin
    //3- Sayfada 147 adet link bulundugunu test edin.
    //4- Products linkine tiklayin
    //5- special offer yazisinin gorundugunu test edin
    //6- Sayfayi kapatin

    @Test
    public void test01() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.automationexercise.com/");
        List <WebElement> linkSayisi=driver.findElements(By.tagName("a"));
        System.out.println(linkSayisi.size());
        int actualLinkSayisi=linkSayisi.size();
        int expectedLinkSayisi=147;
        Assert.assertEquals(expectedLinkSayisi,actualLinkSayisi);
        Thread.sleep(3000);
        driver.close();

    }



}
