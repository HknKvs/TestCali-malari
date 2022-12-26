package December25_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test02 {

    /*
     Google ana sayfasını açın https://www.google.com/.
     Aynı sınıfta Amazon ana sayfasına gidin https://www.amazon.com/
     Google'a geri git
     Amazon'a ilerleyin
     Sayfayı yenileyin
     Tarayıcıyı Kapat/Çık
     Ve son adım: konsolda "All Ok" yazdırın
      */

    @Test
    public void test01 () throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.google.com/");
        Thread.sleep(1000);
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.quit();
        System.out.println("All Ok");



    }
}
