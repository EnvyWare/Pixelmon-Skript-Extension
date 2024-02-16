package com.envyful.pixelmon.skript.elements.effect;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.dialogue.Choice;
import com.pixelmonmod.pixelmon.api.dialogue.Dialogue;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class DialogueEffect extends Effect {

    static {
        Skript.registerEffect(DialogueEffect.class, "dialogue for %player% title %string% description %string% with %choices%");
    }

    private Expression<Player> player;
    private Expression<String> title;
    private Expression<String> description;
    private Expression<Choice> choice;

    @Override
    protected void execute(Event event) {
        var players = this.player.getAll(event);
        var title = this.title.getSingle(event);
        var description = this.description.getSingle(event);
        var choice = this.choice.getAll(event);

        if (title == null || description == null) {
            return;
        }

        var builder = Dialogue.builder()
                .setName(title)
                .setText(description)
                .setChoices(Lists.newArrayList(choice));

        for (var player : players) {
            builder.open(ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayer(player.getUniqueId()));
        }
    }

    @Override
    public String toString(Event event, boolean b) {
        return "dialogue for " + this.player.toString(event, b) + " with title " + this.title.toString(event, b) + " with description " + this.description.toString(event, b) + " with options " + this.choice.toString(event, b);
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.player = (Expression<Player>) expressions[0];
        this.title = (Expression<String>) expressions[1];
        this.description = (Expression<String>) expressions[2];
        this.choice = (Expression<Choice>) expressions[3];
        return true;
    }
}
