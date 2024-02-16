package com.envyful.pixelmon.skript.elements.effect;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import com.pixelmonmod.api.pokemon.PokemonSpecification;
import com.pixelmonmod.pixelmon.api.storage.StorageProxy;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class GivePokemonEffect extends Effect {

    static {
        Skript.registerEffect(GivePokemonEffect.class, "(givepoke|givepokemon|pokegive) %player% %spec%");
    }

    private Expression<Player> player;
    private Expression<PokemonSpecification> spec;

    @Override
    protected void execute(Event event) {
        var player = this.player.getSingle(event);
        var spec = this.spec.getSingle(event).create();

        StorageProxy.getParty(player.getUniqueId()).add(spec);
    }

    @Override
    public String toString(Event event, boolean b) {
        return "give pokemon " + this.player.toString(event, b) + ": " + this.spec.toString(event, b);
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.player = (Expression<Player>) expressions[0];
        this.spec = (Expression<PokemonSpecification>) expressions[1];
        return true;
    }
}
