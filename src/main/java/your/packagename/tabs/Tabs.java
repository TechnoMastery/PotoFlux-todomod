package your.packagename.tabs;

import net.minheur.potoflux.registry.IRegistry;
import net.minheur.potoflux.registry.RegistryList;
import net.minheur.potoflux.screen.tabs.Tab;
import net.minheur.potoflux.utils.ressourcelocation.ResourceLocation;
import your.packagename.ExampleMod;
import your.packagename.tabs.all.YourTabClass;

public class Tabs {
    private static final RegistryList<Tab> LIST = new RegistryList<>();

    // example tab
    public static final Tab MY_TAB = new Tab(new ResourceLocation(ExampleMod.MOD_ID, "your_tab_id"), "Your tab name", YourTabClass.class);

    public static void register(IRegistry<Tab> reg) {
        LIST.register(reg);
    }
}
