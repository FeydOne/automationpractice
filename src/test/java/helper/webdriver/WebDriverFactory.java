package helper.webdriver;

import com.xceptance.xlt.api.util.XltLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by dburtescu on 10/17/2017.
 */
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

   /* public static WebDriver WebDriverFactory() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String browser = System.getProperty("browser").toLowerCase();

        XltLogger.runTimeLogger.debug("Initializing Webdriver");

        switch (browser) {
            case "chrome":
                Path currentRelativePath = Paths.get("");
                String file = currentRelativePath.toAbsolutePath() + "/src/test/resources/browsers";
                System.setProperty("webdriver.chrome.driver", "");
        }
    }*/

}
