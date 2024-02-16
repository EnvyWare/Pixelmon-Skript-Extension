package com.envyful.pixelmon.skript.elements;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import com.envyful.pixelmon.skript.event.DialogueChoiceEvent;
import com.pixelmonmod.api.SpecificationFactory;
import com.pixelmonmod.api.pokemon.PokemonSpecification;
import com.pixelmonmod.api.pokemon.PokemonSpecificationProxy;
import com.pixelmonmod.api.pokemon.requirement.impl.SpeciesRequirement;
import com.pixelmonmod.pixelmon.api.dialogue.Choice;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.ability.Ability;
import com.pixelmonmod.pixelmon.api.pokemon.ability.AbilityRegistry;
import com.pixelmonmod.pixelmon.api.registries.PixelmonRequirements;
import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;
import org.bukkit.Bukkit;

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
        Classes.registerClass(new ClassInfo<>(Ability.class, "ability")
                .name("Ability")
                .description("Represents a Pixelmon Pokemon Ability")
                .usage("ability")
                .after("string", "pokemon")
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
        Classes.registerClass(new ClassInfo<>(PokemonSpecification.class, "spec")
                .name("Spec")
                .description("Represents a Pixelmon Spec")
                .usage("spec")
                .after("string")
                .user("spec")
                .defaultExpression(new EventValueExpression<>(PokemonSpecification.class))
                .parser(new Parser<>() {
                    @Override
                    public PokemonSpecification parse(String s, ParseContext context) {
                        var spec = PokemonSpecificationProxy.create(s);
                        var requirements = SpecificationFactory.requirements(PokemonSpecification.class, s);

                        if (requirements.isEmpty()) {
                            return null;
                        }

                        return spec;
                    }

                    @Override
                    public String toString(PokemonSpecification pokemon, int flags) {
                        return toVariableNameString(pokemon);
                    }

                    @Override
                    public String toVariableNameString(PokemonSpecification pokemon) {
                        return "spec-" + pokemon.toString();
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
                        var text = s;
                        return Choice.builder()
                                .setText(text)
                                .setHandle(dialogueChoiceEvent -> Bukkit.getPluginManager().callEvent(new DialogueChoiceEvent(dialogueChoiceEvent)))
                                .build();
                    }

                    @Override
                    public String toString(Choice pokemon, int flags) {
                        return toVariableNameString(pokemon);
                    }

                    @Override
                    public String toVariableNameString(Choice pokemon) {
                        return "choice" + pokemon.text;
                    }
                }));
    }

}
