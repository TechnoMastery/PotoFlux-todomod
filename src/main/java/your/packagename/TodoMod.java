package your.packagename;

import net.minheur.potoflux.PotoFlux;
import net.minheur.potoflux.loader.PotoFluxLoadingContext;
import net.minheur.potoflux.loader.mod.Mod;
import net.minheur.potoflux.loader.mod.ModEventBus;
import net.minheur.potoflux.loader.mod.events.RegisterTabsEvent;
import your.packagename.tabs.Tabs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    public static Path getModDir() {
        Path dir = PotoFlux.getProgramDir().resolve("mod-data").resolve("todomod");
        try {
            Files.createDirectories(dir);
        } catch (IOException ignored) {}
        return dir;
    }
}
