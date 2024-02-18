package com.envyful.pixelmon.skript.elements;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import com.pixelmonmod.pixelmon.api.dialogue.Choice;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.ability.Ability;
import com.pixelmonmod.pixelmon.api.pokemon.ability.AbilityRegistry;
import com.pixelmonmod.pixelmon.entities.npcs.NPCEntity;
import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;

public class ClassInformation {


    static {
        Classes.registerClass(new ClassInfo<>(Pokemon.class, "pokemon")
                .name("Pokemon")
                .description("Represents a Pixelmon Pokemon")
                .usage("pokemon")
                .user("pokemon")
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
        Classes.registerClass(new ClassInfo<>(PixelmonEntity.class, "pixelmon")
                .name("Pixelmon")
                .description("Represents a Pixelmon Pokemon Entity")
                .usage("pixelmon")
                .user("pixelmon")
                .defaultExpression(new EventValueExpression<>(PixelmonEntity.class))
                .parser(new Parser<>() {
                    @Override
                    public PixelmonEntity parse(String s, ParseContext context) {
                        return null;
                    }

                    @Override
                    public String toString(PixelmonEntity pokemon, int flags) {
                        return toVariableNameString(pokemon);
                    }

                    @Override
                    public String toVariableNameString(PixelmonEntity pokemon) {
                        return "pokemon-" + pokemon.getUUID();
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }
                }));
        Classes.registerClass(new ClassInfo<>(Ability.class, "ability")
                .name("Ability")
                .description("Represents a Pixelmon Pokemon Ability")
                .usage("ability")
                .defaultExpression(new EventValueExpression<>(Ability.class))
                .parser(new Parser<>() {
                    @Override
                    public Ability parse(String s, ParseContext context) {
                        return AbilityRegistry.getAbility(s).orElse(null);
                    }

                    @Override
                    public String toString(Ability pokemon, int flags) {
                        return toVariableNameString(pokemon);
                    }

                    @Override
                    public String toVariableNameString(Ability pokemon) {
                        return "ability-" + pokemon.getName();
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return true;
                    }
                }));
        Classes.registerClass(new ClassInfo<>(Choice.class, "choice")
                .name("Choice")
                .description("Represents a Choice in a dialogue event")
                .usage("choice")
                .after("string")
                .user("choices?")
                .defaultExpression(new EventValueExpression<>(Choice.class))
                .parser(new Parser<>() {
                    @Override
                    public Choice parse(String s, ParseContext context) {
                        return null;
                    }

                    @Override
                    public String toString(Choice pokemon, int flags) {
                        return toVariableNameString(pokemon);
                    }

                    @Override
                    public String toVariableNameString(Choice pokemon) {
                        return pokemon.text;
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }
                }));
        Classes.registerClass(new ClassInfo<>(NPCEntity.class, "npcentity")
                .name("NPC Entity")
                .description("Represents an NPC Entity in Pixelmon")
                .usage("npc")
                .after("string")
                .user("npc")
                .defaultExpression(new EventValueExpression<>(NPCEntity.class))
                .parser(new Parser<>() {

                    @Override
                    public String toString(NPCEntity pokemon, int flags) {
                        return toVariableNameString(pokemon);
                    }

                    @Override
                    public String toVariableNameString(NPCEntity pokemon) {
                        return pokemon.toString();
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }
                }));
    }

}
