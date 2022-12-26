package December26_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test01 {

    //url'ye gidin: https://www.techlistic.com/p/selenium-practice-form.html
    //     ilk adı doldurun
    //     soyadını doldur
    //     cinsiyeti kontrol et
    //     deneyimi kontrol et
    //     tarihi doldur
    //     mesleğinizi seçin -> Otomasyon Test Cihazı
    //     aracınızı seçin -> Selenium Webdriver
    //     kıtanızı seçin -> Avrupa
    //     komutunuzu seçin -> Tarayıcı Komutları
    //     gönder düğmesine tıklayın

    @Test
    public void test01() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Mehmet"+Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Ali"+Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='sex-0']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("exp-0")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("26.12.2022"+Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='profession-1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@name='tool'])[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[@class='input-xlarge'])[1]")).sendKeys("Europe"+Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[@class='input-xlarge'])[2]")).sendKeys("Browser Commands"+Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='btn btn-info']"));

        Thread.sleep(1000);
        driver.close();





    }


}
