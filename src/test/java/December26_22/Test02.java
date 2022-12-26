package December26_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test02 {

    //1. Yeni bir Class olusturalim.C06_ManageWindow
    //2. Amazon soyfasina gidelim. https://www.amazon.com/
    //3. Sayfanin konumunu ve boyutlarini yazdirin
    //4. Sayfayi simge durumuna getirin
    //5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
    //6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
    //7. Sayfayi fullscreen yapin
    //8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
    //9. Sayfayi kapatin

    @Test
    public void test01(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");
        driver.manage().window().minimize();
        driver.getWindowHandles();



    }




}
