package December31_22;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class Test02 extends TestBase {

    //1. “https://www.saucedemo.com” Adresine gidin
    //2. Username kutusuna “standard_user” yazdirin
    //3. Password kutusuna “secret_sauce” yazdirin
    //4. Login tusuna basin
    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    //6. Add to Cart butonuna basin
    //7. Alisveris sepetine tiklayin
    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    //9. Sayfayi kapatin

    @Test
    public void test01() {

    driver.get("https://www.saucedemo.com");
    ReusableMethods.beklemeModu(3);
    driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]")).sendKeys("standard_user"+ Keys.TAB);
    ReusableMethods.beklemeModu(3);
    driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).sendKeys("secret_sauce"+ Keys.TAB);
    ReusableMethods.beklemeModu(3);
    driver.findElement(By.xpath("//input[@type='submit']")).click();
    ReusableMethods.beklemeModu(3);
    WebElement ilkUrunIsmi=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
    driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[1]")).click();
    ReusableMethods.beklemeModu(3);
    driver.findElement(By.className("shopping_cart_link")).click();
    String expectedSepetKontrol="Sauce Labs Backpack";
    String actualSepetKontrol=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
    Assert.assertEquals(expectedSepetKontrol,actualSepetKontrol);






    }
}
