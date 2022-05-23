package ch3_TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Slider extends TestBase {
    @Test
    public void shouldPullPicker() {
        driver.get("https://seleniumui.moderntester.pl/slider.php");

        WebElement handle = driver.findElement(By.id("custom-handle"));
        for (int i = 0; i <50 ; i++) {
            handle.sendKeys(Keys.ARROW_RIGHT);
        }
        for (int i = 0; i <20 ; i++) {
            handle.sendKeys(Keys.ARROW_LEFT);
        }


    }
}
