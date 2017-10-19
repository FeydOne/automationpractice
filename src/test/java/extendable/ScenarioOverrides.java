package extendable;

import com.xceptance.xlt.api.engine.scripting.AbstractWebDriverScriptTestCase;
import helper.webdriver.WebDriverFactory;

public class ScenarioOverrides extends AbstractWebDriverScriptTestCase {
    protected ScenarioOverrides() {
        super(WebDriverFactory.WebDriverFactory(), "");
    }

}
