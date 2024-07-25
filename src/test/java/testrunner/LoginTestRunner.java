package testrunner;

import config.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.LoginPage;
import utils.Utils;

import java.io.IOException;

public class LoginTestRunner extends Setup {
    @Test(priority = 1, description = "user can not login by wrong creds")
    public void loginByWrongCreds(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin("wronguser","wrongpass");
        String alertActual= driver.findElements(By.className("oxd-text")).get(1).getText();
        String alertExpected="Invalid credentials";

        //Assert.assertTrue(alertActual.contains(alertExpected)); //hard assertion

        SoftAssert softAssert=new SoftAssert(); //soft assertion
        softAssert.assertTrue(alertActual.contains(alertExpected));
        softAssert.assertAll();
    }
    @Test(priority = 2, description = "Admin can login successfully")
    public void doLogin() throws IOException, ParseException {
        LoginPage loginPage = new LoginPage(driver);
        Utils utils = new Utils();
        JSONArray jsonArray = utils.getUser();
        JSONObject userObj = (JSONObject) jsonArray.get(0);
        if (System.getProperty("username") == null && System.getProperty("password") == null) {
            String username = (String) userObj.get("username");
            String password = (String) userObj.get("password");
            loginPage.doLogin(username, password);
        } else {
            String username = System.getProperty("username");
            String password = System.getProperty("password");
            loginPage.doLogin(username, password);
        }

        WebElement imgProfile = driver.findElement(By.className("oxd-userdropdown-img"));
        Assert.assertTrue(imgProfile.isDisplayed());
    }
}
