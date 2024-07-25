package testrunner;

import config.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import page.LoginPage;
import utils.Utils;

import java.io.IOException;

public class EmployeeProfileTestRunner extends Setup {
    @Test(priority = 1, description = "Employee can login")
    public void doLogin() throws IOException, ParseException {
        LoginPage loginPage=new LoginPage(driver);
        Utils utils=new Utils();
        JSONArray jsonArray= utils.getUser();
        JSONObject userObj= (JSONObject) jsonArray.get(jsonArray.size()-1);
        String password= (String) userObj.get("password");
        String username= (String) userObj.get("username");

        loginPage.doLogin(username, password);
    }

}
