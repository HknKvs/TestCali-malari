package December28_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test03 {

    //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
    //2- Add Element butonuna basin
    //3- Delete butonu’nun gorunur oldugunu test edin
    //4- Delete tusuna basin
    //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

    @Test
    public void test01() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        Thread.sleep(2000);
        WebElement deleteYazisi= driver.findElement(By.xpath("//button[@class='added-manually']"));
        String actualDeleteYazisi= deleteYazisi.getText();
        String exectedDeleteYazisi= "Delete";
        Assert.assertEquals(exectedDeleteYazisi,actualDeleteYazisi);
        deleteYazisi.click();
        Thread.sleep(2000);
        WebElement addRemoveYazisi= driver.findElement(By.tagName("h3"));
        String actualAddRemoveYazisi= addRemoveYazisi.getText();
        String exectedAddRemoveYazisi= "Add/Remove Elements";
        Assert.assertEquals(exectedAddRemoveYazisi,actualAddRemoveYazisi);

        Thread.sleep(2000);
        driver.close();



    }
}
