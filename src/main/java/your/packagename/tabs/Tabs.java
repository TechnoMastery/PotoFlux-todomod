package your.packagename.tabs;

import net.minheur.potoflux.registry.IRegistry;
import net.minheur.potoflux.registry.RegistryList;
import net.minheur.potoflux.screen.tabs.Tab;
import net.minheur.potoflux.utils.ressourcelocation.ResourceLocation;
import your.packagename.TodoMod;
import your.packagename.tabs.all.TodoTab;

public class Tabs {
    private static final RegistryList<Tab> LIST = new RegistryList<>();

    // example tab
    public static final Tab TODO_TAB = LIST.add(new Tab(new ResourceLocation(TodoMod.MOD_ID, "todo_tab"), "TODO", TodoTab.class));

    public static void register(IRegistry<Tab> reg) {
        LIST.register(reg);
    }
}
