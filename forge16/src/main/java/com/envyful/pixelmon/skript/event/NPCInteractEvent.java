package com.envyful.pixelmon.skript.event;

import com.pixelmonmod.pixelmon.api.events.CaptureEvent;
import com.pixelmonmod.pixelmon.api.events.npc.NPCEvent;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class NPCInteractEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final NPCEvent.Interact event;

    public NPCInteractEvent(NPCEvent.Interact event) {
        this.event = event;
    }

    public NPCEvent.Interact getEvent() {
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
