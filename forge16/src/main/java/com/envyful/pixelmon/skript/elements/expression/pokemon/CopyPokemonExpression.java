package com.envyful.pixelmon.skript.elements.expression.pokemon;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.PokemonBuilder;
import com.pixelmonmod.pixelmon.api.pokemon.ability.Ability;

public class CopyPokemonExpression extends SimplePropertyExpression<Pokemon, Pokemon> {

    static {
        register(CopyPokemonExpression.class, Pokemon.class, "copy", "pokemon");
    }

    @Override
    public Pokemon convert(Pokemon pokemon) {
        return PokemonBuilder.copy(pokemon).build();
    }

    @Override
    protected String getPropertyName() {
        return "copy";
    }

    @Override
    public Class<? extends Pokemon> getReturnType() {
        return Pokemon.class;
    }
}
