package utils;

import config.UsersModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class Utils {
    public static void doScroll(WebDriver driver, int firstPos, int lastPos){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+firstPos+","+lastPos+")");
    }
    public static void saveUsers(UsersModel usersModel) throws IOException, ParseException {
        String fileLocation="./src/test/resources/users.json";
        JSONParser jsonParser=new JSONParser();
        JSONArray jsonArray= (JSONArray) jsonParser.parse(new FileReader(fileLocation));

        JSONObject userObj=new JSONObject();
        userObj.put("firstName",usersModel.getFirstname());
        userObj.put("lastName",usersModel.getLastname());
        userObj.put("username",usersModel.getUsername());
        userObj.put("password",usersModel.getPassword());

        jsonArray.add(userObj);

        FileWriter writer=new FileWriter(fileLocation);
        writer.write(jsonArray.toJSONString());
        writer.flush();
        writer.close();
    }
    public JSONArray getUser() throws IOException, ParseException {
        String fileLocation="./src/test/resources/users.json";
        JSONParser jsonParser=new JSONParser();
        JSONArray jsonArray= (JSONArray) jsonParser.parse(new FileReader(fileLocation));
        return jsonArray;

    }
    public static void waitForElement(WebDriver driver, WebElement element){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}