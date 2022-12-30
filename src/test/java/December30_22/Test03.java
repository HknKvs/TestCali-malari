package December30_22;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class Test03 extends TestBase {

    //1. http://zero.webappsecurity.com sayfasina gidin
    //2. Signin buttonuna tiklayin
    //3. Login alanine “username” yazdirin
    //4. Password alanine “password” yazdirin
    //5. Sign in buttonuna tiklayin
    //6. Pay Bills sayfasina gidin
    //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
    //8. tarih kismina “2020-09-10” yazdirin
    //9. Pay buttonuna tiklayin
    //10. “The payment was successfully submitted.” mesajinin ciktigini test edin

    @Test
    public void test01() {

        driver.get("http://zero.webappsecurity.com");
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username"+ Keys.TAB);
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password"+ Keys.TAB);
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        ReusableMethods.beklemeModu(3);
        driver.navigate().back();
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("(//span[@class='headers'])[4]")).click();
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("1000"+Keys.TAB);
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10"+Keys.TAB);
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("//div[@class='pull-right']")).click();
        WebElement sonucYazisi= driver.findElement(By.xpath("//span[@title='$ 1000 payed to payee sprint']"));
        Assert.assertTrue(sonucYazisi.isDisplayed());











    }
}
