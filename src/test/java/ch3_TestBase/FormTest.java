package ch3_TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormTest extends TestBase{

    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("https://seleniumui.moderntester.pl/form.php");

        WebElement firstName = driver.findElement(By.cssSelector("div input[class='form-control' placeholder=''First name']"));
        firstName.sendKeys("Paweł");

        driver.findElement(By.id("inputLastName3")).sendKeys("Lewandowski");

        WebElement email = driver.findElement(By.id("inputEmail3"));
        email.sendKeys("test@test.pl");

        WebElement age = driver.findElement(By.id("inputAge3"));
        age.sendKeys("36");

        getRandomElement(driver.findElements(By.name("gridRadiosExperience"))).click();

        List<WebElement> professions = driver.findElements(By.name("gridCheckboxProfession"));
        Assert.assertTrue(professions.size()>0);
        for (WebElement profession : professions) {
            profession.click();
        }

        List<WebElement> sex = driver.findElements(By.name("gridRadiosSex"));
        sex.get(0).click();



        Select continents =new Select(driver.findElement(By.id("selectContinents")));
        continents.selectByValue("antarctica");

        Select seleniumCommands =new Select(driver.findElement(By.id("selectSeleniumCommands")));
        seleniumCommands.selectByValue("wait-commands");

        WebElement chooseFile = driver.findElement(By.id("chooseFile"));
        File file = new File("src/main/resources/file.txt");
        chooseFile.sendKeys(file.getAbsolutePath());

        WebElement button = driver.findElement(By.className("btn-primary"));
        button.click();

        String msg = driver.findElement(By.id("validator-message")).getText();
        Assert.assertEquals(msg,"Form send with success");
    }
    public WebElement getRandomElement(List<WebElement> elements){
        Random rnd = new Random();
        int randomListIndex = rnd.nextInt(elements.size());
        return elements.get(randomListIndex);

    }
}

