package ch3_TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SliderPro extends TestBase {
    @Test
    public void shouldPullPicker() {
        driver.get("https://seleniumui.moderntester.pl/slider.php");

        movePicker(50);
        movePicker(30);
        movePicker(30);
        movePicker(20);
        movePicker(65);


    }

    public void movePicker(int key) {
        WebElement handle = driver.findElement(By.id("custom-handle"));
        int actualNumber = Integer.parseInt(handle.getText());

        if (actualNumber < key) {
            for (int i = 0; i < (key - actualNumber); i++) {
                handle.sendKeys(Keys.ARROW_RIGHT);
            }
        } else if (actualNumber > key) {
            for (int i = 0; i < (actualNumber - key); i++) {
                handle.sendKeys(Keys.ARROW_LEFT);
            }
        }
    }


}





