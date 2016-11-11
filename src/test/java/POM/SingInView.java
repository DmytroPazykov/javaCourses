package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SingInView {


    final WebDriver driver;
    public String[] creds;

    //Page URL
    private String PAGE_URL = "https://portal.globallogic.com/access/signin";

    @FindBy(id = "child-align")
    public WebElement GLportal;

    @FindBy(xpath = "/*//*[@ng-model=\'user.username\']")
    public WebElement userName;

    @FindBy(xpath = "/*//*[@ng-model=\'user.password\']")
    public WebElement userPassword;

    @FindBy(xpath = "/*//*[@ng-click=\'login()\']")
    public WebElement loginButton;

    @FindBy(xpath = "/*//*[@ng-show=\'authError\']")
    public WebElement element;

    @FindBy(xpath = "/*//*[@ng-click=\'login()\']")
    public WebElement submitButton;

    public SingInView(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void readCreds() {

        String csvFile = "C:\\Users\\dmytro.pazykov\\javaCourses\\Grid\\creds.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                creds = line.split(cvsSplitBy);
                System.out.println("Login - " + creds[0] + ", password=" + creds[1]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public void login() {
        readCreds();
        userName.sendKeys(creds[0]);
        userPassword.sendKeys(creds[1]);
        loginButton.click();
    }

}
