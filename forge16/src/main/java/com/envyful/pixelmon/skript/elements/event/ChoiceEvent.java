package com.envyful.pixelmon.skript.elements.event;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import com.envyful.pixelmon.skript.event.DialogueChoiceEvent;
import com.pixelmonmod.pixelmon.api.dialogue.Choice;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class ChoiceEvent extends SkriptEvent {

    static {
        Skript.registerEvent("Dialogue Choice", ChoiceEvent.class, DialogueChoiceEvent.class, "choice");

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
    }

    @Override
    public boolean init(Literal<?>[] literals, int i, SkriptParser.ParseResult parseResult) {
        return true;
    }

    @Override
    public boolean check(Event event) {
        System.out.println("Hello World");
        return true;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "on choice";
    }
}
