package ch3_TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrame extends TestBase{

    @Test
    public void shouldFillFormsInIframes(){
        driver.get("https://seleniumui.moderntester.pl/iframes.php");

        driver.switchTo().frame("iframe1");

        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        WebElement surName = driver.findElement(By.id("inputSurname3"));
        WebElement signInButtonFrame1 = driver.findElement(By.cssSelector("button[type='submit']"));
        firstName.sendKeys("Jan");
        surName.sendKeys("Kowalski");
        signInButtonFrame1.click();
        driver.switchTo().defaultContent();

        driver.switchTo().frame("iframe2");

        WebElement login = driver.findElement(By.id("inputLogin"));
        WebElement password = driver.findElement(By.id("inputPassword"));
        Select continent =new Select(driver.findElement(By.id("inlineFormCustomSelectPref")));
        WebElement yearOfExperience = driver.findElement(By.id("gridRadios2"));
        WebElement signInButtonFrame2 = driver.findElement(By.cssSelector("button[type='submit']"));

        login.sendKeys("John");
        password.sendKeys("haslo");
        continent.selectByValue("africa");
        yearOfExperience.click();
        signInButtonFrame2.click();

        driver.switchTo().defaultContent();
    }




}
