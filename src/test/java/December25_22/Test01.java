package December25_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test01 {

    /*..........Exercise1............
    BeforeClass ile driver'i olusturun ve class icinde static yapin
    Maximize edin ve 10 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.google.com");
    }

    @Test
    public void test01() throws InterruptedException {

        WebElement aramaKutusu1= driver.findElement(By.className("gLFyf"));
        aramaKutusu1.sendKeys("The Lord of the Rings"+ Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucYazisi.getText()); //Yaklaşık 261.000.000 sonuç bulundu
        driver.navigate().back();

    }

    @Test
    public void test02() throws InterruptedException {

        WebElement aramaKutusu2= driver.findElement(By.className("gLFyf"));
        aramaKutusu2.sendKeys("Brave Heart" + Keys.ENTER);
        WebElement sonucYazisi2= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucYazisi2.getText()); //Yaklaşık 215.000.000 sonuç bulundu
        driver.navigate().back();

    }

    @Test
    public  void test03() throws InterruptedException {

        WebElement aramaKutusu3 = driver.findElement(By.className("gLFyf"));
        aramaKutusu3.sendKeys("Harry Potter"+ Keys.ENTER);
        WebElement sonucYazisi3= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucYazisi3.getText()); //Yaklaşık 467.000.000 sonuç bulundu (0,46 saniye)

    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }






}
