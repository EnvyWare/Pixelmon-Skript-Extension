package com.envyful.pixelmon.skript.elements.exrepssion.pokemon;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.ability.Ability;

public class PokemonAbilityExpression extends SimplePropertyExpression<Pokemon, Ability> {

    static {
        register(PokemonAbilityExpression.class, Ability.class, "ability", "pokemon");
    }

    @Override
    public Ability convert(Pokemon pokemon) {
        return pokemon.getAbility();
    }

    @Override
    protected String getPropertyName() {
        return "ability";
    }

    @Override
    public Class<? extends Ability> getReturnType() {
        return Ability.class;
    }
}
