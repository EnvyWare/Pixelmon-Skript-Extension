package com.envyful.pixelmon.skript.elements.expression;

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

public class PlayerPartyExpression extends SimpleExpression<Pokemon> {

    static {
        Skript.registerExpression(PlayerPartyExpression.class, Pokemon.class, ExpressionType.COMBINED, "party of %player%");
    }

    private Expression<Player> player;

    @Override
    protected Pokemon[] get(Event event) {
        var player = this.player.getSingle(event);

        var partyStorage = StorageProxy.getParty(player.getUniqueId());

        if (partyStorage == null) {
            return null;
        }

        return partyStorage.getAll();
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
        return "party" + this.player.toString(event, debug);
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.player = (Expression<Player>) expressions[1];
        return true;
    }
}
