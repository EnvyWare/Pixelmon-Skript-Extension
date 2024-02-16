package com.envyful.pixelmon.skript.elements;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

public class ClassInformation {


    static {
        Classes.registerClass(new ClassInfo<>(Pokemon.class, "pokemon")
                .name("Pokemon")
                .description("Represents a Pixelmon Pokemon")
                .usage("pokemon")
                .after("string")
                .defaultExpression(new EventValueExpression<>(Pokemon.class))
                .parser(new Parser<>() {
                    @Override
                    public Pokemon parse(String s, ParseContext context) {
                        return null;
                    }

                    @Override
                    public String toString(Pokemon pokemon, int flags) {
                        return toVariableNameString(pokemon);
                    }

                    @Override
                    public String toVariableNameString(Pokemon pokemon) {
                        return "pokemon-" + pokemon.getUUID();
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }
                }));
    }

}
