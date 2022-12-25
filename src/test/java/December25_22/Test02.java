package December25_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test02 {

    @Test
    public void test01(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.google.com");
        WebElement aramaKutusu = driver.findElement(By.className("gLFyf"));
        aramaKutusu.sendKeys("Kelebeklerin Midesindeki Asit Miktarı Nedir" + Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='TbwUpd NJjxre'])[2]")).click();
        driver.close();






    }
}
