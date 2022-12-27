package December27_22;

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
    //3- Category bolumundeki elementleri locate edin
    //4- Category bolumunde 3 element oldugunu test edin
    //5- Category isimlerini yazdirin
    //6- Sayfayi kapatin

    @Test
    public void test01() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.automationexercise.com/");
        List <WebElement> categorySayisi= driver.findElements(By.xpath("//div[@id='accordian']"));

        for (WebElement each:categorySayisi
        ) {
            System.out.println(each.getText());
            System.out.println(categorySayisi.size());

        }

        driver.close();


    }

}
