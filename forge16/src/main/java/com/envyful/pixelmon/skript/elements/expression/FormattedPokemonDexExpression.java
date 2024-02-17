package com.envyful.pixelmon.skript.elements.expression;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

public class FormattedPokemonDexExpression extends SimplePropertyExpression<Pokemon, String> {

    static {
        register(FormattedPokemonDexExpression.class, String.class, "formatteddex", "pokemon");
    }

    @Override
    public String convert(Pokemon pokemon) {
        return pokemon.getSpecies().getFormattedDex();
    }

    @Override
    protected String getPropertyName() {
        return "formatteddex";
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
