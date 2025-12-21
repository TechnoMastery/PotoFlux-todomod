package net.minheur.potoflux_todomod;

import net.minheur.potoflux.PotoFlux;
import net.minheur.potoflux.loader.PotoFluxLoadingContext;
import net.minheur.potoflux.loader.mod.Mod;
import net.minheur.potoflux.loader.mod.ModEventBus;
import net.minheur.potoflux.loader.mod.events.RegisterLangEvent;
import net.minheur.potoflux.loader.mod.events.RegisterTabsEvent;
import net.minheur.potoflux_todomod.tabs.Tabs;
import net.minheur.potoflux_todomod.translations.TodoTranslations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Mod(modId = TodoMod.MOD_ID)
public class TodoMod {
    public static final String MOD_ID = "todomod";

    public TodoMod() {
        ModEventBus modEventBus = PotoFluxLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::onRegisterLang);
        modEventBus.addListener(Tabs::register);
    }

    private void onRegisterLang(RegisterLangEvent event) {
        event.registerLang(new TodoTranslations());
    }

    public static Path getModDir() {
        Path dir = PotoFlux.getModDataDir().resolve(MOD_ID);
        try {
            Files.createDirectories(dir);
        } catch (IOException ignored) {}
        return dir;
    }
}
