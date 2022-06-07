package ch3_TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Tables extends TestBase {


    @Test
    public void shouldPrintAllMountainsNamesAnHeights() {
        driver.get("https://seleniumui.moderntester.pl/table.php");

        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        Assert.assertTrue(rows.size() > 0);

        for (WebElement row : rows) {
            String rank = row.findElement(By.cssSelector("th")).getText();
            String peakName = row.findElements(By.cssSelector("td")).get(0).getText();
            String peakState = row.findElements(By.cssSelector("td")).get(2).getText();
         //   int height = Integer.parseInt(row.findElement(By.xpath("td[4]")).getText());
            int height = Integer.parseInt(row.findElements(By.cssSelector("td")).get(3).getText());
            if (height > 4000) {
                System.out.println("Peak rank: " + rank);
                System.out.println("Peak name: " + peakName);
                System.out.println("Peak state: " + peakState);
                System.out.println("Peak height: " + height);
                System.out.println("");
            }
        }

    }


}
