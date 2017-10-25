package testsuites.AutomationPractice.modules;

import extendable.ModulesOverrides;

public class MOpenHomepage extends ModulesOverrides {
    @Override
    protected void doCommands(String... strings) throws Exception {
        startAction("OpenStartPage");
        open("http://automationpractice.com/index.php");
        waitForPageToLoad();
        deleteAllVisibleCookies();
    }
}
