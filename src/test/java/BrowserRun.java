import POM.SingInView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserRun {
    public WebDriver driver;
    SingInView singInView;
    public void firefox(String URL) throws MalformedURLException {
        System.out.println(" Executing on FireFox\n");
        String Node = "http://localhost:5555/wd/hub";
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setBrowserName("firefox");
        driver = new RemoteWebDriver(new URL(Node), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Launch website
        driver.navigate().to(URL);
        singInView = new SingInView(driver);
        driver.manage().window().maximize();
    }
    void  chrome(String URL) throws MalformedURLException {
        System.out.println(" Executing on CHROME\n");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setBrowserName("chrome");
        String Node = "http://localhost:5557/wd/hub";
        driver = new RemoteWebDriver(new URL(Node), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Launch website
        driver.navigate().to(URL);
        singInView = new SingInView(driver);
        driver.manage().window().maximize();


    }
    void  ie(String URL) throws MalformedURLException {
        System.out.println(" Executing on IE");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setBrowserName("internet explorer");
        String Node = "http://localhost:5558/wd/hub";
        driver = new RemoteWebDriver(new URL(Node), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(URL);
        singInView = new SingInView(driver);
        driver.manage().window().maximize();
    }
}
