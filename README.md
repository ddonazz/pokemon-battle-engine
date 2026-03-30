# Pokemon Battle Engine

A modular Java engine for simulating Pokémon battles using a compositional design.

## Features

* **Component-Based Moves**: Moves are built by combining attempts, effects, and conditions rather than hard-coding
  logic.
* **Flexible Damage**: Supports fixed damage, ranges, and formula-based calculations.
* **Targeting System**: Easily define if effects hit the attacker or defender.
* **Extensible Conditions**: Built-in support for probabilities, type checks, and status effects.

## Technical Stack

* **Language**: Java 21
* **Build Tool**: Maven

## Quick Start

Define a move by nesting its logic:

```java
Move tackle = new Move(
    "Tackle",
    PokemonType.NORMAL,
    new Attempt(
        new Probability<>(0.95), // 95% Accuracy
        new FormulaDamage(new Exactly(40)) // 40 Base Damage
    )
);