package testsuites.AutomationPractice.modules;

import extendable.ModulesOverrides;

/**
 * Created by dburtescu on 10/25/2017.
 */
public class MAssertTopNav extends ModulesOverrides {
    @Override
    protected void doCommands(String... strings) throws Exception {
        assertVisible("css=.logo.img-responsive");
        assertVisible("id=search_query_top");
        assertVisible("css=.shopping_cart");
        assertVisible("css=.header_user_info");
        assertVisible("css=.shop-phone");
    }
}
