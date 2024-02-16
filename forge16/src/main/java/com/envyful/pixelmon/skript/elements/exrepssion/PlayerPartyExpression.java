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

public class PlayerPartyExpression extends SimpleExpression<Pokemon> {

    static {
        Skript.registerExpression(PlayerPartyExpression.class, Pokemon.class, ExpressionType.COMBINED, "pokemon %number% of %player%");
    }

    private Expression<Player> player;
    private Expression<Number> party;

    @Override
    protected Pokemon[] get(Event event) {
        var player = this.player.getSingle(event);
        var slot = this.party.getSingle(event);

        var partyStorage = StorageProxy.getParty(player.getUniqueId());

        if (partyStorage == null) {
            return null;
        }

        return new Pokemon[] {partyStorage.getAll()[slot.intValue() - 1]};
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends Pokemon> getReturnType() {
        return Pokemon.class;
    }

    @Override
    public String toString(Event event, boolean debug) {
        return "pokemon";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.player = (Expression<Player>) expressions[1];
        this.party = (Expression<Number>) expressions[0];
        return true;
    }
}
