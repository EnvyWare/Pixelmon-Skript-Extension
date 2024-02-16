package com.envyful.pixelmon.skript.elements.exrepssion;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.storage.StorageProxy;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class PlayerPCBoxExpression extends SimpleExpression<Pokemon> {

    static {
        Skript.registerExpression(PlayerPCBoxExpression.class, Pokemon.class, ExpressionType.COMBINED, "box %number% for %player%");
    }

    private Expression<Player> player;
    private Expression<Number> box;

    @Override
    protected Pokemon[] get(Event event) {
        var player = this.player.getSingle(event);

        var pcStorage = StorageProxy.getPCForPlayer(player.getUniqueId());

        if (pcStorage == null) {
            return null;
        }

        return pcStorage.getBox(box.getSingle(event).intValue()).getAll();
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    @Override
    public Class<? extends Pokemon> getReturnType() {
        return Pokemon.class;
    }

    @Override
    public String toString(Event event, boolean debug) {
        return "pc box " + this.box.toString(event, debug) + " for " + this.player.toString(event, debug);
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.player = (Expression<Player>) expressions[1];
        this.box = (Expression<Number>) expressions[0];
        return true;
    }
}
