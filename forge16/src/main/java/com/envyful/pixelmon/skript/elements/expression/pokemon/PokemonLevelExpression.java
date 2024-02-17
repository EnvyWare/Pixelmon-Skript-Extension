package com.envyful.pixelmon.skript.elements.expression.pokemon;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

public class PokemonLevelExpression extends SimplePropertyExpression<Pokemon, Integer> {

    static {
        register(PokemonLevelExpression.class, Integer.class, "level", "pokemon");
    }

    @Override
    public Integer convert(Pokemon pokemon) {
        return pokemon.getPokemonLevel();
    }

    @Override
    protected String getPropertyName() {
        return "level";
    }

    @Override
    public Class<? extends Integer> getReturnType() {
        return Integer.class;
    }
}
