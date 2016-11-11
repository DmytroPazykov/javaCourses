import POM.MainView;
import org.junit.*;
import org.junit.Test;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class TestPageSelenium extends BrowserRun{



    final String myName = "Dmytro Pazykov";


    @Parameters({"browser", "url"})
    @BeforeTest
    public void launchApp(String browser, @Optional("https://portal.globallogic.com/access/signin") String URL) throws IOException {

        switch (browser){
            case "firefox":
                firefox(URL);
                break;
            case "chrome":
                chrome(URL);
                break;
            case "ie":
                ie(URL);
                break;
            default:
                throw new IllegalArgumentException("The Browser Type is Undefined");
        }
    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

    @org.testng.annotations.Test
    public void checkAccountName() throws InterruptedException{
        singInView.login();
        Thread.sleep(2000);
        MainView mainView = new MainView(driver);
        mainView.openPersonalInfo();
        assertTrue(myName.equals(mainView.getAccountUserName()));
        mainView.logout();

    }

    @org.testng.annotations.Test
    public void checkUserNameOnMap() throws InterruptedException{
        singInView.login();
        Thread.sleep(2000);
        MainView mainView = new MainView(driver);
        mainView.openOfficeMap();
        mainView.openWorspace57();
        assertTrue(myName.equals(mainView.getProfileConteiner()));
        mainView.openPersonalInfo();
        mainView.logout();

//        mainView.logout();

    }
}