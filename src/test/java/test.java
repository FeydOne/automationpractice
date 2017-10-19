import extendable.ScenarioOverrides;
import org.junit.Test;

/**
 * Created by dburtescu on 10/17/2017.
 */
public class test extends ScenarioOverrides {

    @Test
    public void testMethod() {
        String browser = System.getProperty("browser");
        System.out.println(browser);
        open("https://www.google.ro");
        type("css=.gsfi", "Manchester City");
        clickAndWait("name=btnK");

        assertTextPresent("Manchester City");
    }
}
