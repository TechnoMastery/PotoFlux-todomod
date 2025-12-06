package your.packagename;

import net.minheur.potoflux.loader.PotoFluxLoadingContext;
import net.minheur.potoflux.loader.mod.Mod;
import net.minheur.potoflux.loader.mod.ModEventBus;
import net.minheur.potoflux.loader.mod.events.RegisterTabsEvent;
import your.packagename.tabs.Tabs;

@Mod(modId = ExampleMod.MOD_ID)
public class ExampleMod {
    public static final String MOD_ID = "yourmodid";

    public ExampleMod() {
        ModEventBus modEventBus = PotoFluxLoadingContext.get().getModEventBus();

        modEventBus.addListener(RegisterTabsEvent.class, this::onRegisterTabs);
    }

    private void onRegisterTabs(RegisterTabsEvent event) {
        Tabs.register(event.reg);
    }
}
