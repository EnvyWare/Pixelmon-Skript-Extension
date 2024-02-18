package com.envyful.pixelmon.skript.elements.effect;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import com.envyful.api.forge.chat.UtilChatColour;
import com.pixelmonmod.pixelmon.api.util.helpers.NetworkHelper;
import com.pixelmonmod.pixelmon.comm.packetHandlers.dialogue.OpenDialogueInputPacket;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class DialogueInputEffect extends Effect {

    static {
        Skript.registerEffect(DialogueInputEffect.class, "(1¦closeable|2¦not closeable) input for %player% title %string% description %string% with default text %strings%");
    }

    private Expression<Player> player;
    private Expression<String> title;
    private Expression<String> description;
    private Expression<String> defaultValue;
    private boolean closeable = true;

    @Override
    protected void execute(Event event) {
        var players = this.player.getAll(event);
        var title = this.title.getSingle(event);
        var description = this.description.getSingle(event);
        var defaultValue = this.defaultValue.getSingle(event);

        if (title == null || description == null) {
            return;
        }

        for (var player : players) {
            NetworkHelper.sendPacket(ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayer(player.getUniqueId()), new OpenDialogueInputPacket(
                    UtilChatColour.colour(title),
                    UtilChatColour.colour(description),
                    defaultValue, this.closeable));
        }
    }

    @Override
    public String toString(Event event, boolean b) {
        return (this.closeable ? "closeable" : "not closeable") + " input for " + this.player.toString(event, b) + " title " + this.title.toString(event, b) + " description " + this.description.toString(event, b) + " with default text " + this.defaultValue.toString(event, b);
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.player = (Expression<Player>) expressions[0];
        this.title = (Expression<String>) expressions[1];
        this.description = (Expression<String>) expressions[2];
        this.defaultValue = (Expression<String>) expressions[3];
        this.closeable = parseResult.mark == 1;
        return true;
    }
}
