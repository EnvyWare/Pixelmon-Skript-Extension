package com.envyful.pixelmon.skript;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class PixelmonSkript extends JavaPlugin {

    private SkriptAddon addon;

    @Override
    public void onEnable() {
       this.addon = Skript.registerAddon(this);

       try {
           this.addon.loadClasses("com.envyful.pixelmon.skript", "elements");
       } catch (IOException e) {
           this.getLogger().severe("Failed to load classes");
       }
    }

    @Override
    public void onDisable() {

    }
}
