package com.envyful.pixelmon.skript.event;

import com.pixelmonmod.pixelmon.api.events.dialogue.DialogueInputEvent;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DialogueInputSubmitEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final DialogueInputEvent.Submitted event;

    public DialogueInputSubmitEvent(DialogueInputEvent.Submitted event) {
        this.event = event;
    }

    public DialogueInputEvent.Submitted getEvent() {
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
