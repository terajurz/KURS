package ch3_TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Waitty extends TestBase {
    @Test
    public void shouldAddProductToBasket() {
        driver.get("http://146.59.32.4/index.php?id_product=6&rewrite=mug-the-best-is-yet-to-come&controller=product&id_lang=2");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addToCartButton = driver.findElement(By.cssSelector(".add-to-cart"));
        addToCartButton.click();
        WebElement proceedToCheckoutButton = driver.findElement(By.cssSelector(".modal-body a"));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
        //    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".modal-body a"))).click();
        WebElement deleteButton = driver.findElement(By.cssSelector(".remove-from-cart"));
        deleteButton.click();
        //List<WebElement> bin = driver.findElements(By.cssSelector(".remove-from-cart"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(deleteButton));
        WebElement cartOverview = driver.findElement(By.cssSelector(".no-items"));

        Assert.assertEquals(cartOverview.getText(), "There are no more items in your cart");


    }
}
