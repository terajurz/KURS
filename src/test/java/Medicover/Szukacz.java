package Medicover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Szukacz extends Setup {

    @Test
        public void szukanie() {
            driver.get("https://login.medicover.pl/Account/Login?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3Dis3%26redirect_uri%3Dhttps%253A%252F%252Foauth.medicover.pl%252Fsignin-oidc%26response_mode%3Dform_post%26response_type%3Dcode%2520id_token%26scope%3Dopenid%2520profile%26state%3DOpenIdConnect.AuthenticationProperties%253DiDGp16zOJ_sUnM7yBFgTXrbcY5YMThDX7KR8xOr7VRignkANBmDuf65lAKBRkAGWIN-vMnSzuCY6PJ5zWnkFj1nZXFBHbqbdIJ28odYUXmpuBkT2gZKcwiwJ00taYJZ0u6HWofX1zArPhMlDLm9qK9jxUnpzGPYg4peOFlrjYpKZgitNFRGvvr7pZyKsEdp_njqDJWRVU2569m2xojBEFN6XKcFYPROYHjg_jWCw1XGVDewoykKbnVog3snxVQ2RDm0QYtOGsm21NSy2QIcdEteeRtI%26nonce%3D637889322081553391.MzZmZTgwYTgtMzc1Ny00N2E1LTg1OTktMDJkMDMyZDEwOGE5NmRlNzk3N2ItMTliMy00ZDVjLTg4ZTktMTRhYjZlOTc0ZTY5%26ui_locales%3Dpl-PL%26owner%3DMcov_Mol");


            WebElement userName = driver.findElement(By.cssSelector("#UserName"));
        wait.until(ExpectedConditions.elementToBeClickable(userName));
            userName.sendKeys("1025652");
            //signUpForm page
            WebElement password = driver.findElement(By.cssSelector("#Password"));
            password.sendKeys("Pawe1357!");
            WebElement login = driver.findElement(By.cssSelector("#loginBtn"));
            login.click();
//            WebElement saveButton = driver.findElement(By.cssSelector("#content button[type='submit']"));
//            saveButton.click();
//            //mainPage
//            WebElement userInfo = driver.findElement(By.cssSelector("#_desktop_user_info span"));
//            Assert.assertEquals(userInfo.getText(), "Jan Kowalski");
        }

}






