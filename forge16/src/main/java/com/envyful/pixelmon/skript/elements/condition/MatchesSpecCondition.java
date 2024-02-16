package com.envyful.pixelmon.skript.elements.condition;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import com.pixelmonmod.api.pokemon.PokemonSpecification;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import org.bukkit.event.Event;

public class MatchesSpecCondition extends Condition {

    static {
        Skript.registerCondition(MatchesSpecCondition.class, "%pokemon% (1¦matches|2¦does not match) %spec%");
    }

    private Expression<Pokemon> pokemon;
    private Expression<PokemonSpecification> spec;

    @Override
    public boolean check(Event event) {
        return spec.getSingle(event).matches(pokemon.getSingle(event)) == this.isNegated();
    }

    @Override
    public String toString(Event event, boolean debug) {
        return this.spec.toString();
    }

    @Override
    public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.pokemon = (Expression<Pokemon>) expressions[0];
        this.spec = (Expression<PokemonSpecification>) expressions[1];
        this.setNegated(parseResult.mark == 1);
        return true;
    }
}
