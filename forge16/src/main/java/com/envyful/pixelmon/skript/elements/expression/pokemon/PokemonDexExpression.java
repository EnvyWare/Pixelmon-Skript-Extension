package com.envyful.pixelmon.skript.elements.expression.pokemon;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

public class PokemonDexExpression extends SimplePropertyExpression<Pokemon, Integer> {

    static {
        register(PokemonDexExpression.class, Integer.class, "dex", "pokemon");
    }

    @Override
    public Integer convert(Pokemon pokemon) {
        return pokemon.getSpecies().getDex();
    }

    @Override
    protected String getPropertyName() {
        return "dex";
    }

    @Override
    public Class<? extends Integer> getReturnType() {
        return Integer.class;
    }
}
