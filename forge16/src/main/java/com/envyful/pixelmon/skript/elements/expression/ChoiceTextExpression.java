package com.envyful.pixelmon.skript.elements.expression;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import com.pixelmonmod.pixelmon.api.dialogue.Choice;

public class ChoiceTextExpression extends SimplePropertyExpression<Choice, String> {

    static {
        register(ChoiceTextExpression.class, String.class, "text", "choice");
    }

    @Override
    public String convert(Choice choice) {
        return choice.text;
    }

    @Override
    protected String getPropertyName() {
        return "text";
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
