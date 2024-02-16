package com.envyful.pixelmon.skript.elements.event;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import com.envyful.pixelmon.skript.event.DialogueInputCloseEvent;
import com.envyful.pixelmon.skript.event.DialogueInputSubmitEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class InputCloseEvent extends SkriptEvent {

    static {
        Skript.registerEvent("Dialogue Input Close", InputCloseEvent.class, DialogueInputCloseEvent.class, "dialogue input close");

        EventValues.registerEventValue(DialogueInputCloseEvent.class, Player.class, new Getter<>() {
            @Override
            public Player get(DialogueInputCloseEvent e) {
                return Bukkit.getPlayer(e.getEvent().getPlayer().getUUID());
            }
        }, 0);
    }

    @Override
    public boolean init(Literal<?>[] literals, int i, SkriptParser.ParseResult parseResult) {
        return true;
    }

    @Override
    public boolean check(Event event) {
        return true;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "on dialogue input close";
    }
}
