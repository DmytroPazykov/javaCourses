package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dmytro.pazykov on 11/9/2016.
 */
public class MainView {
    final WebDriver driver;

    //Page URL
    private String PAGE_URL = "https://portal.globallogic.com/";

    @FindBy(xpath = "//*[@ng-click=\'header.logout()\']")
    public WebElement logOutButton;

    @FindBy(xpath = "/*//*[@ng-show=\'selfInfo.avatar\']")
    public WebElement personalInfoButton;

    @FindBy(id = "user-account")
    public WebElement accountUserName;

    @FindBy(className = "officemap-service-item")
    public WebElement officeMap;

    @FindBy(xpath = "//*[@ng-click=\'close()\']")
    public WebElement skipButtonOnPopUp;

    @FindBy(id = "ODS--1--table--57")
    public WebElement customWorkspace;

    @FindBy(css = ".glm-block-name")
    public WebElement odsMap;

    public String getProfileConteiner() {
        return profileConteiner.getText();
    }

    @FindBy(xpath = "//section[@class='col-xs-45 title-user']//h2")
    public WebElement profileConteiner;

    public MainView(WebDriver driver) {
        this.driver = driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }
    public String getAccountUserName() {
        return accountUserName.getText();
    }

    public void openOfficeMap(){
        officeMap.click();
        skipButtonOnPopUp.click();
        odsMap.click();
    }
    public void openWorspace57(){customWorkspace.click();}
    public void logout() {
        logOutButton.click();
    }

    public void openPersonalInfo() {
        personalInfoButton.click();
    }
}
