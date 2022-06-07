package ch7_Pop;

import ch3_TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class Ex1_FormPop extends TestBase {
    FormPage formPage;
    File file = new File("src/main/resources/file.txt");

    @BeforeMethod
    public void testSetup() {
        formPage = new FormPage(driver);
        driver.get("https://seleniumui.moderntester.pl/form.php");

    }

    @Test
    public void shouldFillFormWithSuccess() {


        formPage.setFirstName("Jan")
                .setLastName("Kowalski")
                .setEmail("JK@gmail.com")
                .setAge("99")
                .selectRandomGender()
                .selectContinent("europe")
                .selectRandomYearsOfExperience()
                .selectAllProfessions()
                .fileUpload(file)
                .selectSeleniumCommand("browser-commands")
                .clickSignInBtn();

        Assert.assertEquals(formPage.getValidationMsg(), "Form send with success");
    }
}
