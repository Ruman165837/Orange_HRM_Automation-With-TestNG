package testrunner;

import com.github.javafaker.Faker;
import config.Setup;
import config.UsersModel;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.LoginPage;
import page.PIMPage;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class PIMTestRunner extends Setup {

    @BeforeTest
    public void doLogin(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin("admin","admin123");
    }
    @Test(priority = 1, description = "Create new employee")
    public void employeeRegistration() throws InterruptedException, IOException, ParseException {
        PIMPage pimPage=new PIMPage(driver);
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String username=faker.name().username();
        String password="P@ssword123";
        pimPage.registerUser(firstName, lastName, username, password);
        Utils.doScroll(driver,0,300);
        //Thread.sleep(7000);
        List<WebElement> title= driver.findElements(By.className("orangehrm-main-title"));
//        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));
//        wait.until(ExpectedConditions.visibilityOf(title.get(0))); //wait for personal details title
        Utils.waitForElement(driver, title.get(0));

        UsersModel usersModel=new UsersModel();
        usersModel.setUsername(username);
        usersModel.setPassword(password);
        Utils.saveUsers(usersModel);
    }
}
