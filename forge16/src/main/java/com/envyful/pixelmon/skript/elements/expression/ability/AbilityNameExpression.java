package com.envyful.pixelmon.skript.elements.expression.ability;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import com.pixelmonmod.pixelmon.api.pokemon.ability.Ability;

public class AbilityNameExpression extends SimplePropertyExpression<Ability, String> {

    static {
        register(AbilityNameExpression.class, String.class, "abilityname", "ability");
    }

    @Override
    public String convert(Ability pokemon) {
        return pokemon.getName();
    }

    @Override
    protected String getPropertyName() {
        return "abilityname";
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
