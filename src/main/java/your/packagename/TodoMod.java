package your.packagename;

import net.minheur.potoflux.loader.PotoFluxLoadingContext;
import net.minheur.potoflux.loader.mod.Mod;
import net.minheur.potoflux.loader.mod.ModEventBus;
import net.minheur.potoflux.loader.mod.events.RegisterTabsEvent;
import your.packagename.tabs.Tabs;

@Mod(modId = TodoMod.MOD_ID)
public class TodoMod {
    public static final String MOD_ID = "todomod";

    public TodoMod() {
        ModEventBus modEventBus = PotoFluxLoadingContext.get().getModEventBus();

        modEventBus.addListener(RegisterTabsEvent.class, this::onRegisterTabs);
    }

    private void onRegisterTabs(RegisterTabsEvent event) {
        Tabs.register(event.reg);
    }
}
