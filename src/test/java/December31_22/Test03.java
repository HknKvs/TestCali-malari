package December31_22;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

public class Test03 extends TestBase {

    //a. Verilen web sayfasına gidin.
    //https://the-internet.herokuapp.com/checkboxes
    //b. Checkbox1 ve checkbox2 elementlerini locate edin.
    //c. Checkbox1 seçili değilse onay kutusunu tıklayın
    //d. Checkbox2 seçili değilse onay kutusunu tıklayın

    @Test
    public void test01() {

        driver.get("https://the-internet.herokuapp.com/checkboxes");
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
        ReusableMethods.beklemeModu(3);
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        ReusableMethods.beklemeModu(3);
    }
}
