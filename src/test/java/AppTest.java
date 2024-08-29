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
        openMobileApp();
        testing();
    }

    public static void openMobileApp() throws MalformedURLException {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("deviceName", "mediumFirst");
            cap.setCapability("platformName", "Android");
            cap.setCapability("platformVersion", "7.0");
            cap.setCapability("automationName", "UiAutomator2");
            cap.setCapability("app", "C:\\Users\\belalahmad\\Desktop\\appiumProject\\frist_android_test\\src\\main\\resources\\app-release.apk");
            cap.setCapability("noReset", true);

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(url, cap);
            System.out.println("Application started");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testing() {
        // Set the timeout in seconds directly
        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Subtract"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Add"))).click();
    }
}
