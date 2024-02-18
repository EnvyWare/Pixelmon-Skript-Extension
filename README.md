# Pixelmon Skript Extension [![Join our Discord](https://img.shields.io/discord/831966641586831431.svg?logo=discord&label=)](https://discord.envyware.co.uk) 
An extension for the Skript language on Spigot that adds Pixelmon API support


> **NOTE** \
> The below explanation expects a basic level of knowledge of Skript, if you don't know what Skript is, you can find out more [here](https://www.spigotmc.org/resources/skript.114544/)

## Features

### Table Of Contents
- [Conditions](#conditions)
- [Expressions](#expressions)
- [Effect](#effect)
- [Events](#events)
- [Example](#example)

### Conditions

#### Matches Spec
This condition checks if a given Pokemon matches any given specs.
Example:
```skript
if {_pokemon} matches shiny:
   message "wow"
```

The above checks if the Pokemon in the variable `_pokemon` is a shiny, and if it is then it'll send the message "wow".

This can also be used to in the opposite way like so:
```skript
if {_pokemon} does not match "shiny":
   message "not shiny"
```

### Expressions

#### Duplicate/Copy Pokemon
This allows you to make an exact copy of the Pokemon, with a new UUID.
```skript
set {_copy_pokemon} to {_pokemon}'s copy
```

#### Species Name
This allows you to get the name of the species of a pokemon
```skript
set {_name} to {_pokemon}'s species
```

#### Pokemon's Level
This allows you to get the level of the Pokemon
```skript
set {_level} to {_pokemon}'s level
```

#### Pokemon's Palette
This allows you to get the palette of the Pokemon
```skript
set {_level} to {_pokemon}'s palette
```

#### Pokemon Form
This allows you to get the name of the form of a pokemon
```skript
set {_form} to {_pokemon}'s form
```

#### Pokemon Ability
This allows you to get the ability of the pokemon
```skript
set {_ability} to {_pokemon}'s ability
```

#### Ability Name
This allows you to get the name of an ability
```skript
set {_ability} to {_pokemon}'s ability
set {_ability_name} to {_ability}'s abilityname
```

#### Pokemon Dex
This allows you to get the dex number of a pokemon
```skript
set {_dex} to {_pokemon}'s dex
```

#### Pokemon Formatted Dex
This allows you to get the dex number of a pokemon in the "pretty" format (i.e. 001)
```skript
set {_dex} to {_pokemon}'s formatteddex
```

#### Player's Party Pokemon
This allows you to get a player's pokemon from their party
```skript
set {_pokemon} to pokemon 1 of {_player}
```

#### Player's PC Pokemon
This allows you to get a player's pokemon from their PC
```skript
set {_pokemon} to pokemon 1 of box 1 for {_player}
```

#### Player's PC Box
This allows you to get all the pokemon in a player's box in their PC
```skript
set {_pokemon::*} to box 1 for {_player}
```

#### Player's Party
This allows you to get all the pokemon in a player's party
```skript
set {_pokemon::*} to party of {_player}
```

### Effect

#### Spawn Pokemon
This allows you to spawn a pokemon at a location
```skript
set {_location} to position of {_player}
pokespawn {_location} "random shiny"
```

#### Give Pokemon
This allows you to give a player a pokemon
```skript
givepoke {_player} "random shiny"
```

#### Dialogue Box
This allows you to open a dialogue box for a player
```skript
add "Test one" to {_choices::*}
add "Test two" to {_choices::*}
dialogue for {_player} title "Hello World" description "Description!" with {_choices::*}
```

> **NOTE** \
> If you use this in the dialogue choice event then
> it will pass through to the next dialogue box seemlessly

#### Input Dialogue Box
This allows you to open an input dialogue box for a player
```skript
not closeable input for {_player} title "Hello World" description "Enter text please" with default text "Wow!"
```

or 
```skript
closeable input for {_player} title "Hello World" description "Enter text please" with default text "Wow!"
```

### Events

#### Choice Event
This event is triggered when a player selects a choice from a dialogue box
```skript
on choice:
  set {_player} to player
  set {_choice} to choice
  message "%{_player}% %{_choice}%"
```

#### Dialogue Input Event
This event is triggered when the player inputs text into a dialogue input box
```skript
on dialogue input:
  message "Hello World"
  set {_player} to player
  set {_input} to event-string
  message "%{_player}% %{_input}%"
```

#### Dialogue Input Close Event
This event is triggered when the player closes a dialogue input box
```skript
on dialogue input close:
  message "wow!"
```

#### Successful Capture Event
This event is triggered when a player successfully captures a Pokemon
```skript
on successful capture:
   set {_player} to player
   set {_pokemon} to event-pokemon
   set {_entity} to event-pixelmon
   message "WOW! %{_pokemon}% %{_player}% %{_test}%"
```

### Example
```skript
on join:
   set {_player} to player

   message "%{_player}%"

   set {_pokemon} to pokemon 1 of {_player}
   set {_dex} to {_pokemon}'s dex
   set {_formatted_dex} to {_pokemon}'s formatteddex
   message "%{_pokemon}% %{_dex}% %{_formatted_dex}%"
   wait 2 seconds
   add "Test one" to {_choices::*}
   add "Test two" to {_choices::*}
   not closeable input for {_player} title "Hello World" description "Enter text please" with default text "Wow!"

   set {_location} to position of {_player}

   pokespawn {_location} "random shiny"

   if {_pokemon} matches "shiny":
      set {_name} to {_pokemon}'s species
      message "%{_name}%"
      wait 10 seconds
      givepoke {_player} "random shiny"

on choice:
   set {_player} to player
   set {_choice} to choice
   message "%{_player}% %{_choice}%"

on dialogue input:
   message "Hello World"
   set {_player} to player
   set {_input} to event-string
   message "%{_player}% %{_input}%"

on dialogue input close:
   message "wow!"

on successful capture:
   set {_player} to player
   set {_pokemon} to event-pixelmon
   set {_test} to event-pokemon
   message "WOW! %{_pokemon}% %{_player}% %{_test}%"
```