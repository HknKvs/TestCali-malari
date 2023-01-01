package January01_23;

import com.github.javafaker.Faker;
import com.google.j2objc.annotations.Property;
import org.apache.hc.core5.http.protocol.RequestUserAgent;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class Test02 extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Contact Us' button
    //5. Verify 'GET IN TOUCH' is visible
    //6. Enter name, email, subject and message
    //7. Upload file
    //8. Click 'Submit' button
    //9. Click OK button
    //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    //11. Click 'Home' button and verify that landed to home page successfully

    @Test
    public void test01() {

        driver.get(https+"automationexercise"+com);
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://automationexercise.com/";
        Assert.assertEquals(expectedUrl,actualUrl);
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
        String actualGetInTouch=driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]")).getText();
        String expectedGetInTouch="GET IN TOUCH";
        Assert.assertEquals(expectedGetInTouch,actualGetInTouch);
        WebElement firstName= driver.findElement(By.xpath("//input[@name='name']"));
        Actions actions=new Actions(driver);
        Faker faker = new Faker();
        String mailAdresi=faker.internet().emailAddress();
        actions.click(firstName)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys("Java")
                .sendKeys(Keys.TAB)
                .sendKeys("Selenium").perform();
        ReusableMethods.beklemeModu(3);
        WebElement dosyaYoluSec= driver.findElement(By.xpath("//input[@type='file']"));
        String dosyaYolu= System.getProperty("user.home")+"//Desktop//MerhabaJava.docx";
        dosyaYoluSec.sendKeys(dosyaYolu);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.switchTo().alert().accept();
        WebElement successYazisi= driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(successYazisi.isDisplayed());
        driver.navigate().to("http://automationexercise.com");
    }
}

