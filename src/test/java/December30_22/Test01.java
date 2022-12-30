package December30_22;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class Test01 extends TestBase {

    //https://www.facebook.com sayfasına gidin
    //cookies'i kabul et
    //yeni hesap oluştur'a tıklayın
    //ilgili alanları faker kutuphanesinden degerlerle doldurup
    // kaydol butonuna basın
    //kayıt olamadıgınızı test edin

    @Test
    public void test01() {

        driver.get("https://www.facebook.com");
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement fistName= driver.findElement(By.name("firstname"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String mailAdresi=faker.internet().emailAddress();
        actions.click(fistName)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("Oct")
                .sendKeys(Keys.TAB)
                .sendKeys("1987")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).perform();
        WebElement signupButonu= driver.findElement(By.name("websubmit"));
        signupButonu.click();

        ReusableMethods.beklemeModu(5);
        WebElement hataMesajElementi= driver.findElement(By.xpath("(//div[@class='_58mo'])[1]"));
        Assert.assertTrue(hataMesajElementi.isDisplayed());
        ReusableMethods.beklemeModu(5);
    }
}
