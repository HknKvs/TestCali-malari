package December26_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test04 {

    //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
    //doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
    //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
    //doğru URL'yi yazdırın.
    //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
    //5. Youtube sayfasina geri donun
    //6. Sayfayi yenileyin
    //7. Amazon sayfasina donun
    //8. Sayfayi tamsayfa yapin
    //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
    //Yoksa doğru başlığı(Actual Title) yazdırın.
    //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse
    //doğru URL'yi yazdırın
    //11.Sayfayi kapatin

    @Test
    public void test01() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.youtube.com");
        String actualBaslik=driver.getTitle();
        String expectedBaslik="YouTube";
        Assert.assertEquals(actualBaslik,expectedBaslik);
        System.out.println(driver.getCurrentUrl().contains("YouTube"));
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.manage().window().fullscreen();
        System.out.println(driver.getTitle().contains("amazon"));
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl().contains("amazon"));
        System.out.println(driver.getCurrentUrl());
        driver.close();


    }
}
