package com.envyful.pixelmon.skript.elements.expression;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import com.pixelmonmod.pixelmon.api.dialogue.Choice;

public class ChoiceIDExpression extends SimplePropertyExpression<Choice, Integer> {

    static {
        register(ChoiceIDExpression.class, Integer.class, "choiceID", "choice");
    }

    @Override
    public Integer convert(Choice choice) {
        return choice.choiceID;
    }

    @Override
    protected String getPropertyName() {
        return "choiceID";
    }

    @Override
    public Class<? extends Integer> getReturnType() {
        return Integer.class;
    }
}
