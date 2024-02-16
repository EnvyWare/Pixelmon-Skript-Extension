package com.envyful.pixelmon.skript.event;

import com.pixelmonmod.pixelmon.api.events.dialogue.DialogueInputEvent;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DialogueInputCloseEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final DialogueInputEvent.ClosedScreen event;

    public DialogueInputCloseEvent(DialogueInputEvent.ClosedScreen event) {
        this.event = event;
    }

    public DialogueInputEvent.ClosedScreen getEvent() {
        return this.event;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
