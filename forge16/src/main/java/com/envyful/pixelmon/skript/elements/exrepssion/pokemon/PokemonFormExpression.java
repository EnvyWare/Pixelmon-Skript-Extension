package com.envyful.pixelmon.skript.elements.exrepssion.pokemon;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

public class PokemonFormExpression extends SimplePropertyExpression<Pokemon, String> {

    static {
        register(PokemonFormExpression.class, String.class, "form", "pokemon");
    }

    @Override
    public String convert(Pokemon pokemon) {
        return pokemon.getForm().getName();
    }

    @Override
    protected String getPropertyName() {
        return "form";
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
