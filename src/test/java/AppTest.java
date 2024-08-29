import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {
    static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException {
        AndroidApp1("Galaxy.*", "11", "Android");
        testing();
    }

    public static void AndroidApp1(String device, String version, String platform) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "Java TestNG");
        capabilities.setCapability("name", platform + " " + device + " " + version);
        capabilities.setCapability("deviceName", device);
        capabilities.setCapability("platformVersion", version);
        capabilities.setCapability("platformName", platform);
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("app", "lt://APP10160571441724918016368480");
        capabilities.setCapability("deviceOrientation", "PORTRAIT");
        capabilities.setCapability("network", false);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("devicelog", true);
        capabilities.setCapability("autoGrantPermissions", true);

        String userName = "belalahmad";
        String accessKey = "cousQqH3syuMR3H55LiQfG4QqCyPHRsZs3XJ3mbEle94hOdYLj";
        String gridUrl = "mobile-hub.lambdatest.com";

        // Use AndroidDriver directly without casting
        driver = new AndroidDriver(new URL("https://" + userName + ":" + accessKey + "@" + gridUrl + "/wd/hub"), capabilities);
    }

    public static void testing() {
        // Your testing logic here
        WebDriverWait wait = new WebDriverWait(driver, 10);
        for (int i = 0; i < 10; i++) { // Loop to perform the click action 10 times
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Add"))).click();
            System.out.println("Click " + (i + 1) + " performed.");
        }
    }
}
