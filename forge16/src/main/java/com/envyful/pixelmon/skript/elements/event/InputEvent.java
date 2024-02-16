package com.envyful.pixelmon.skript.elements.event;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import com.envyful.pixelmon.skript.event.DialogueChoiceEvent;
import com.envyful.pixelmon.skript.event.DialogueInputSubmitEvent;
import com.pixelmonmod.pixelmon.api.dialogue.Choice;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class InputEvent extends SkriptEvent {

    static {
        Skript.registerEvent("Dialogue Input", InputEvent.class, DialogueInputSubmitEvent.class, "dialogue input");

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
        return "on dialogue input";
    }
}
