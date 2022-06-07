package ch3_TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDrop extends TestBase {




    @Test
    public void shouldDragAndDropElement1() {

        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        Actions actions = new Actions(driver);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        actions.clickAndHold(drag).moveToElement(drop).release().perform();
        Assert.assertEquals(drop.getText(), "Dropped!");
    }

    @Test
    public void shouldDragAndDropElement2() {

        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        Actions actions = new Actions(driver);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(drag, drop).perform();
        Assert.assertEquals(drop.getText(), "Dropped!");
    }

    @Test
    public void shouldDragAndDropElement3() {

        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        Actions actions = new Actions(driver);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        actions.clickAndHold(drag).moveByOffset(250, 0).release().perform();
        Assert.assertEquals(drop.getText(), "Dropped!");
    }

    @Test
    public void shouldDragAndDropElement4() {

        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        Actions actions = new Actions(driver);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        int getX = drag.getLocation().getX();
        int getY = drag.getLocation().getY();
        int getZ = drop.getLocation().getX();
        int getW = drop.getLocation().getY();

        actions.clickAndHold(drag).moveByOffset((getZ-getX), (getW-getY)).release().perform();
        Assert.assertEquals(drop.getText(), "Dropped!");
    }

}
