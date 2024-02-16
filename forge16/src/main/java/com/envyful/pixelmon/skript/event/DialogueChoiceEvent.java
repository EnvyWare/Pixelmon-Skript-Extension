package com.envyful.pixelmon.skript.event;

import com.pixelmonmod.pixelmon.api.dialogue.Choice;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DialogueChoiceEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final com.pixelmonmod.pixelmon.api.events.dialogue.DialogueChoiceEvent event;

    public DialogueChoiceEvent(com.pixelmonmod.pixelmon.api.events.dialogue.DialogueChoiceEvent event) {
        this.event = event;
    }

    public com.pixelmonmod.pixelmon.api.events.dialogue.DialogueChoiceEvent getEvent() {
        return this.event;
    }

    public Choice getChoice() {
        return this.event.choice;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
