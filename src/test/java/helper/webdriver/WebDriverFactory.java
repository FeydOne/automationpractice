package helper.webdriver;

import com.xceptance.xlt.api.util.XltLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    private static final int IMPLICIT_TIMEOUT = 40;
    private static final int PAGELOAD_TIMEOUT = 60;
    private static WebDriver driver;

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                XltLogger.runTimeLogger.debug("Shutdown Hook triggered. Webdriver instance was terminated");
                if (driver != null) {
                    System.out.println();
                    driver.quit();
                }
            }
        });
    }

    public static WebDriver WebDriverFactory() {

        String browser = System.getProperty("browser").toLowerCase();

        XltLogger.runTimeLogger.debug("Initializing Webdriver");

        switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                configureDriver("webdriver.chrome.driver", "chromedriver");
                driver = new ChromeDriver(options);
                XltLogger.runTimeLogger.debug("Chrome Driver is selected\n");
                break;
            case "firefox":
                configureDriver("webdriver.gecko.driver", "geckodriver");
                FirefoxOptions firefoxOptions = new FirefoxOptions()
                        .setProfile(new FirefoxProfile());
                firefoxOptions.setCapability("marionette", false);
                driver = new FirefoxDriver();
                XltLogger.runTimeLogger.debug("Firefox Driver is selected\n");
                break;
            case "edge":
                configureDriver("webdriver.edge.driver", "MicrosoftWebDriver");
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                XltLogger.runTimeLogger.debug("Edge Driver is selected\n");

        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(PAGELOAD_TIMEOUT, TimeUnit.SECONDS);

        driver.switchTo().window(driver.getWindowHandle());
        return driver;
    }

    private static void configureDriver(String property, String driverServiceName) {
        Path currentRelativePath = Paths.get("");
        System.setProperty(property, String.valueOf(currentRelativePath) + "src/test/resources/browsers/" + driverServiceName + ".exe");
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
