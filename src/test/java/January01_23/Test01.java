package January01_23;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.ReusableMethods;
import utilities.TestBase;

public class Test01 extends TestBase {

    //  http://www.bestbuy.com 'a gidin,
    //  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
    //  Ayrica Relative Locator kullanarak;
    // logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
    //  Ayrica Relative Locator kullanarak;
    // mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin

    @Test
    public void test01() {

        driver.get(https+"bestbuy.com");
        String expectedSayfaBasligi="Best";
        String actualSayfaBasligi= driver.getTitle();
        Boolean sayfaBasligiVarMi=actualSayfaBasligi.contains(expectedSayfaBasligi);
        Assert.assertTrue(sayfaBasligiVarMi);
        ReusableMethods.beklemeModu(5);
        WebElement helloHeading= driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
        WebElement logo= driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeading));
        Assert.assertTrue(logo.isDisplayed());
        ReusableMethods.beklemeModu(5);
        WebElement unitedStates= driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement mexicoLinkTest= driver.findElement(RelativeLocator.with(By.xpath("(//img[@alt='Mexico'])[1]")).toRightOf(unitedStates));
        Assert.assertTrue(mexicoLinkTest.isDisplayed());
    }
}
