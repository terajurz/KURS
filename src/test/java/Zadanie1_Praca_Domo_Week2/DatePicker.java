package Zadanie1_Praca_Domo_Week2;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatePicker extends TestBase {
    @Test
    public void shouldPickDate(){
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");

        WebElement datePicker = driver.findElement(By.cssSelector("#datepicker"));
        datePicker.sendKeys("08/31/2022");
        Assert.assertEquals(datePicker.getAttribute("value"), "08/31/2022");
    }
}
