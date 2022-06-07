
//ZADANIE 1
//#homefeatured .right-block .price



package HomeWork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class LoginPage extends TestBase {



    @Test
    public void shouldSignUpWithSuccess() {
        driver.get("http://146.59.32.4/index.php");
        //main page
        WebElement signInButton = driver.findElement(By.cssSelector("#_desktop_user_info .hidden-sm-down"));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
        //signIn page
        WebElement accountButton = driver.findElement(By.cssSelector(".no-account"));
        accountButton.click();
        //signUpForm page
        List<WebElement> socialTitle = driver.findElements(By.cssSelector("#customer-form .radio-inline"));
        wait.until(ExpectedConditions.elementToBeClickable(socialTitle.get(0)));
        socialTitle.get(0).click();
        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("Jan");
        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.sendKeys("Kowalski");
        WebElement email = driver.findElement(By.cssSelector("#content input[name='email']"));
        email.sendKeys(randomEmail());
        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        password.sendKeys("12345");
        WebElement customerPrivacy = driver.findElement(By.cssSelector("input[name='customer_privacy']"));
        customerPrivacy.click();
        WebElement privacyPolicy = driver.findElement(By.cssSelector("input[name='psgdpr']"));
        privacyPolicy.click();
        WebElement saveButton = driver.findElement(By.cssSelector("#content button[type='submit']"));
        saveButton.click();
        //mainPage
        WebElement userInfo = driver.findElement(By.cssSelector("#_desktop_user_info span"));
        Assert.assertEquals(userInfo.getText(), "Jan Kowalski");
    }


    public String randomEmail() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return "username" + randomInt + "@gmail.com";
    }


}




