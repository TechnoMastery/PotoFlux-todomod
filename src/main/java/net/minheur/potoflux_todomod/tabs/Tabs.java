package net.minheur.potoflux_todomod.tabs;

import net.minheur.potoflux.registry.IRegistry;
import net.minheur.potoflux.registry.RegistryList;
import net.minheur.potoflux.screen.tabs.Tab;
import net.minheur.potoflux.translations.Translations;
import net.minheur.potoflux.utils.ressourcelocation.ResourceLocation;
import net.minheur.potoflux_todomod.TodoMod;
import net.minheur.potoflux_todomod.tabs.all.TodoTab;

public class Tabs {
    private static final RegistryList<Tab> LIST = new RegistryList<>();

    // example tab
    public static final Tab TODO_TAB = LIST.add(new Tab(new ResourceLocation(TodoMod.MOD_ID, "todo_tab"), Translations.get("tabs.todo.name"), TodoTab.class));

    public static void register(IRegistry<Tab> reg) {
        LIST.register(reg);
    }
}
