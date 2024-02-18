package com.envyful.pixelmon.skript.elements.event;

import ch.njol.skript.Skript;
import ch.njol.skript.classes.data.BukkitClasses;
import ch.njol.skript.lang.util.SimpleEvent;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import com.envyful.pixelmon.skript.event.*;
import com.pixelmonmod.pixelmon.api.dialogue.Choice;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.entities.npcs.NPCEntity;
import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;
import org.bukkit.Bukkit;
import org.bukkit.entity.NPC;
import org.bukkit.entity.Player;

public class PixelmonEvents {

    static {
        Skript.registerEvent("Successful capture", SimpleEvent.class, SuccessfulCaptureEvent.class, "successful capture");
        Skript.registerEvent("Dialogue Choice", SimpleEvent.class, DialogueChoiceEvent.class, "choice");
        Skript.registerEvent("Dialogue Input Close", SimpleEvent.class, DialogueInputCloseEvent.class, "dialogue input close");
        Skript.registerEvent("Dialogue Input", SimpleEvent.class, DialogueInputSubmitEvent.class, "dialogue input");
        Skript.registerEvent("NPC Interact", SimpleEvent.class, NPCInteractEvent.class, "npc interact");

        EventValues.registerEventValue(DialogueInputSubmitEvent.class, Player.class, new Getter<>() {
            @Override
            public Player get(DialogueInputSubmitEvent e) {
                return Bukkit.getPlayer(e.getEvent().getPlayer().getUUID());
            }
        }, 0);

        EventValues.registerEventValue(DialogueInputSubmitEvent.class, String.class, new Getter<>() {
            @Override
            public String get(DialogueInputSubmitEvent e) {
                return e.getEvent().getInput();
            }
        }, 0);

        EventValues.registerEventValue(SuccessfulCaptureEvent.class, Player.class, new Getter<>() {
            @Override
            public Player get(SuccessfulCaptureEvent e) {
                return Bukkit.getPlayer(e.getEvent().getPlayer().getUUID());
            }
        }, 0);

        EventValues.registerEventValue(SuccessfulCaptureEvent.class, Pokemon.class, new Getter<>() {
            @Override
            public Pokemon get(SuccessfulCaptureEvent e) {
                return e.getEvent().getPokemon().getPokemon();
            }
        }, 0);

        EventValues.registerEventValue(SuccessfulCaptureEvent.class, PixelmonEntity.class, new Getter<>() {
            @Override
            public PixelmonEntity get(SuccessfulCaptureEvent e) {
                return e.getEvent().getPokemon();
            }
        }, 0);

        EventValues.registerEventValue(DialogueChoiceEvent.class, Player.class, new Getter<>() {
            @Override
            public Player get(DialogueChoiceEvent e) {
                return Bukkit.getPlayer(e.getEvent().player.getUUID());
            }
        }, 0);

        EventValues.registerEventValue(DialogueChoiceEvent.class, Choice.class, new Getter<>() {
            @Override
            public Choice get(DialogueChoiceEvent e) {
                return e.getChoice();
            }
        }, 0);

        EventValues.registerEventValue(DialogueInputCloseEvent.class, Player.class, new Getter<>() {
            @Override
            public Player get(DialogueInputCloseEvent e) {
                return Bukkit.getPlayer(e.getEvent().getPlayer().getUUID());
            }
        }, 0);

        EventValues.registerEventValue(NPCInteractEvent.class, Player.class, new Getter<>() {
            @Override
            public Player get(NPCInteractEvent e) {
                return Bukkit.getPlayer(e.getEvent().player.getUUID());
            }
        }, 0);

        EventValues.registerEventValue(NPCInteractEvent.class, NPCEntity.class, new Getter<>() {
            @Override
            public NPCEntity get(NPCInteractEvent e) {
                return e.getEvent().npc;
            }
        }, 0);

    }

}
