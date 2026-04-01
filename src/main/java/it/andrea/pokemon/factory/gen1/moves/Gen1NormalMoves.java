package it.andrea.pokemon.factory.gen1.moves;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.attempt.Attempt;
import it.andrea.pokemon.model.condition.Probability;
import it.andrea.pokemon.model.effect.FormulaDamage;
import it.andrea.pokemon.model.move.IMove;
import it.andrea.pokemon.model.move.Move;
import it.andrea.pokemon.model.number.*;
import it.andrea.pokemon.utils.PokemonType;
import it.andrea.pokemon.utils.StatType;

import java.util.Map;
import java.util.function.Supplier;

public class Gen1NormalMoves {

    public static void register(Map<String, Supplier<IMove>> registry) {
        registry.put("Tackle", Gen1NormalMoves::createTackle);
    }

    public static IMove createTackle() {
        return Move.of(
                "Tackle",
                PokemonType.NORMAL,
                Attempt.of(
                        Probability.of(0.95),
                        new FormulaDamage(
                                Gen1Damage.builder()
                                        .level(new Level(Battle::getAttacker))
                                        .power(new Exactly(35))
                                        .critical(new CriticalHitMultiplier(Probability.of(0.625), new Exactly(2)))
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
