package January04_23;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test01 extends TestBase {

    // https://www.automationexercise.com/ sayfasina gidelim
    // signUp linkine tiklayalim
    // name ve email adress kismina bilgiler gondererek uye olalim
    // uye olundugunu test edelim

    @Test
    public void test01() {

        driver.get(https+"automationexercise"+com);
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        WebElement name= driver.findElement(By.xpath("//input[@type='text']"));
        name.sendKeys("Java" + Keys.TAB);
        WebElement mail= driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        mail.sendKeys("java@gmail.com"  + Keys.ENTER);
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("13572468" + Keys.TAB);
        driver.findElement(By.xpath("//select[@id='days']")).sendKeys("15" + Keys.TAB);
        driver.findElement(By.xpath("//select[@id='months']")).sendKeys("January" + Keys.TAB);
        driver.findElement(By.xpath("//select[@id='years']")).sendKeys("1987" + Keys.TAB);
        //driver.findElement(By.xpath("(//div[@class='checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//input[@class='form-control'])[4]")).sendKeys("Java"+Keys.TAB);
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("Güzeldir"+Keys.TAB);
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("Wisequarter"+Keys.TAB);
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("Ankara"+Keys.TAB);
        driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("İstanbul"+Keys.TAB);
        driver.findElement(By.xpath("//select[@data-qa='country']")).sendKeys("United States"+Keys.TAB);
        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Tester"+Keys.TAB);
        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Ankara"+Keys.TAB);
        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("06930"+Keys.TAB);
        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("05555555555"+Keys.TAB);
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        String actualKayitKontrol=driver.findElement(By.xpath("//*[text()='Account Created!']")).getText();
        String expectedKayitKontrol="ACCOUNT CREATED!";
        Assert.assertEquals(expectedKayitKontrol,actualKayitKontrol);





















    }

}
