package Medicover;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Setup {



        public WebDriver driver;
        public WebDriverWait wait;
        public Duration seconds;


        @BeforeMethod
        public void setup() {
            WebDriverManager.chromedriver().setup();

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");

            driver = new ChromeDriver(chromeOptions);
            seconds = Duration.ofSeconds(3);
            wait = new WebDriverWait(driver, seconds);
        }

        @AfterMethod
        public void cleanUp() {
            driver.quit();
        }

    }


