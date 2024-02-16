package com.envyful.pixelmon.skript.elements.effect;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import com.envyful.api.forge.world.UtilWorld;
import com.pixelmonmod.api.pokemon.PokemonSpecification;
import org.bukkit.Location;
import org.bukkit.event.Event;

public class SpawnPokemonEffect extends Effect {

    static {
        Skript.registerEffect(SpawnPokemonEffect.class, "(pokespawn|spawnpokemon|spawnpoke) %location% %spec%");
    }

    private Expression<Location> location;
    private Expression<PokemonSpecification> spec;

    @Override
    protected void execute(Event event) {
        var location = this.location.getSingle(event);
        var spec = this.spec.getSingle(event);
        var forgeWorld = UtilWorld.findWorld(location.getWorld().getName());

        var pokemonEntity = spec.create(forgeWorld);
        pokemonEntity.setPos(location.getX(), location.getY(), location.getZ());
        forgeWorld.addFreshEntity(pokemonEntity);
    }

    @Override
    public String toString(Event event, boolean b) {
        return "give pokemon " + this.location.toString(event, b) + ": " + this.spec.toString(event, b);
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.location = (Expression<Location>) expressions[0];
        this.spec = (Expression<PokemonSpecification>) expressions[1];
        return true;
    }
}
