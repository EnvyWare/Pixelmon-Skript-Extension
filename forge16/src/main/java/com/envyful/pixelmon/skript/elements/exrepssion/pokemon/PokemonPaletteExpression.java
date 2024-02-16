package com.envyful.pixelmon.skript.elements.exrepssion.pokemon;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

public class PokemonPaletteExpression extends SimplePropertyExpression<Pokemon, String> {

    static {
        register(PokemonPaletteExpression.class, String.class, "palette", "pokemon");
    }

    @Override
    public String convert(Pokemon pokemon) {
        return pokemon.getPalette().getName();
    }

    @Override
    protected String getPropertyName() {
        return "palette";
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
