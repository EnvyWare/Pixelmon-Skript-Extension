package com.envyful.pixelmon.skript.event;

import com.pixelmonmod.pixelmon.api.events.CaptureEvent;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SuccessfulCaptureEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final CaptureEvent.SuccessfulCapture event;

    public SuccessfulCaptureEvent(CaptureEvent.SuccessfulCapture event) {
        this.event = event;
    }

    public CaptureEvent.SuccessfulCapture getEvent() {
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
