package it.andrea.pokemon;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.battle.PokemonStats;
import it.andrea.pokemon.battle.StatType;
import it.andrea.pokemon.model.attempt.Attempt;
import it.andrea.pokemon.model.condition.Probability;
import it.andrea.pokemon.model.effect.FormulaDamage;
import it.andrea.pokemon.model.move.Move;
import it.andrea.pokemon.model.number.*;
import it.andrea.pokemon.utils.PokemonType;

public class Main {

    public static void main(String[] args) {
        Move tackle = new Move(
                "Tackle",
                PokemonType.NORMAL,
                new Attempt(
                        new Probability<>(0.95),
                        new FormulaDamage(
                                Gen1Damage.builder()
                                        .level(new Level(Battle::getAttacker))
                                        .power(new Exactly(40))
                                        .attack(new TargetStat(Battle::getAttacker, StatType.ATTACK))
                                        .defense(new TargetStat(Battle::getDefender, StatType.DEFENSE))
                                        .stab(new SameTypeAttackBonus(Battle::getAttacker, PokemonType.NORMAL))
                                        .type1(new TypeEffectiveness(Battle::getDefender, PokemonType.NORMAL, 0))
                                        .type2(new TypeEffectiveness(Battle::getDefender, PokemonType.NORMAL, 1))
                                        .build(),
                                Battle::getDefender
                        )
                )
        );
    }
}
