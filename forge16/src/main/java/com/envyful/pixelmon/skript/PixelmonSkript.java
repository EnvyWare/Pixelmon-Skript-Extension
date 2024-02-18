package com.envyful.pixelmon.skript;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import com.envyful.pixelmon.skript.event.DialogueInputCloseEvent;
import com.envyful.pixelmon.skript.event.DialogueInputSubmitEvent;
import com.envyful.pixelmon.skript.event.NPCInteractEvent;
import com.envyful.pixelmon.skript.event.SuccessfulCaptureEvent;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.events.CaptureEvent;
import com.pixelmonmod.pixelmon.api.events.dialogue.DialogueInputEvent;
import com.pixelmonmod.pixelmon.api.events.npc.NPCEvent;
import net.minecraftforge.eventbus.api.EventPriority;
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

        Pixelmon.EVENT_BUS.addListener(EventPriority.HIGH, true, DialogueInputEvent.Submitted.class, event -> this.getServer().getPluginManager().callEvent(new DialogueInputSubmitEvent(event)));
        Pixelmon.EVENT_BUS.addListener(EventPriority.HIGH, true, DialogueInputEvent.ClosedScreen.class, event -> this.getServer().getPluginManager().callEvent(new DialogueInputCloseEvent(event)));
        Pixelmon.EVENT_BUS.addListener(EventPriority.HIGH, true, CaptureEvent.SuccessfulCapture.class,event -> this.getServer().getPluginManager().callEvent(new SuccessfulCaptureEvent(event)));
        Pixelmon.EVENT_BUS.addListener(EventPriority.HIGH, true, NPCEvent.Interact.class,event -> this.getServer().getPluginManager().callEvent(new NPCInteractEvent(event)));
    }

    @Override
    public void onDisable() {

    }
}
