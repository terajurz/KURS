package ch3_TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.time.Duration;

public class Wait extends TestBase {
    @Test
    public void shouldWaitForAlert() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement delayedAlert = driver.findElement(By.id("delayed-alert"));
        WebElement alertText = driver.findElement(By.id("delayed-alert-label"));

        delayedAlert.click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
//        wait.until(ExpectedConditions.alertIsPresent());
//        driver.switchTo().alert().accept();
        Assert.assertEquals(alertText.getText(), "OK button pressed");
    }

    @Test
    public void shouldWaitForComplete1() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement progressBar = driver.findElement(By.id("progressbar"));

        wait.until(ExpectedConditions.textToBePresentInElement(progressBar,"Complete!"));
        wait.until(ExpectedConditions.textToBe(By.id("progressbar"),"Complete!"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("progressbar"),"Complete!"));


    }

    @Test
    public void shouldWaitForComplete2() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement progressBarClass = driver.findElement(By.cssSelector(".ui-progressbar-value"));

        wait.until(ExpectedConditions.attributeContains(progressBarClass,"class","ui-progressbar-complete"));
        wait.until(ExpectedConditions.attributeToBe(progressBarClass,"class","ui-progressbar-value ui-corner-left ui-widget-header ui-progressbar-complete ui-corner-right"));

}
}
