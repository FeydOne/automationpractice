package testsuites.AutomationPractice.scenarios.regression;

import extendable.ScenarioOverrides;
import org.junit.Test;
import testsuites.AutomationPractice.modules.MAssertTopNav;
import testsuites.AutomationPractice.modules.MOpenHomepage;

public class Homepage extends ScenarioOverrides {

    @Test
    public void testMethod() throws Exception {
        MOpenHomepage openHomepage = new MOpenHomepage();
        openHomepage.execute();

        MAssertTopNav assertTopNav = new MAssertTopNav();
        assertTopNav.execute();

        clickAndWait("css=#block_top_menu ul li:nth-of-type(1) >a");
        assertTitle("Women - My Store");
    }
}
