package com.envyful.pixelmon.skript.elements.expression;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

public class SpeciesNameExpression extends SimplePropertyExpression<Pokemon, String> {

    static {
        register(SpeciesNameExpression.class, String.class, "species", "pokemon");
    }

    @Override
    public String convert(Pokemon pokemon) {
        return pokemon.getSpecies().getName();
    }

    @Override
    protected String getPropertyName() {
        return "species";
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
