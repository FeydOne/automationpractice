package helper.webdriver;

import org.junit.rules.TestWatcher;

/**
 * Created by dburtescu on 10/25/2017.
 */
public class TestResultProcessor extends TestWatcher {
    private static final String SMOKE = "smoke";
    private static final String REGRESSION = "regression";

    private final String name;
    private final String testDescription;
    private final String[] testLabels;

    public TestResultProcessor(String name, String testDescription, String[] testLabels) {
        this.name = name;
        this.testDescription = testDescription;
        this.testLabels = testLabels;
    }
}
