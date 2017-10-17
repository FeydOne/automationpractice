package extendable;

import com.xceptance.xlt.api.engine.scripting.AbstractWebDriverScriptTestCase;
import org.openqa.selenium.WebDriver;

/**
 * Created by dburtescu on 10/17/2017.
 */
public class ScenarioOverrides extends AbstractWebDriverScriptTestCase {
    public ScenarioOverrides(WebDriver driver, String baseUrl) {
        super(driver, baseUrl);
    }
}
