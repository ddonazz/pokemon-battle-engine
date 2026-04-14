package it.andrea.pokemon.model.rules.gen1;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.factory.IMoveRegistry;
import it.andrea.pokemon.factory.gen1.Gen1MoveRegistry;
import it.andrea.pokemon.model.number.*;
import it.andrea.pokemon.model.rules.IGenerationRuleset;
import it.andrea.pokemon.model.rules.ITypeChart;
import it.andrea.pokemon.utils.DamageCategory;
import it.andrea.pokemon.utils.PokemonType;
import it.andrea.pokemon.utils.StatType;

public class Gen1Ruleset implements IGenerationRuleset {

    private static final Gen1Ruleset INSTANCE = new Gen1Ruleset();

    private Gen1Ruleset() {
    }

    public static Gen1Ruleset getInstance() {
        return INSTANCE;
    }

    @Override
    public INumber createDamageFormula(INumber basePower, PokemonType moveType, DamageCategory category) {
        StatType attackStat = (category == DamageCategory.PHYSICAL) ? StatType.ATTACK : StatType.SPECIAL_ATTACK;
        StatType defenseStat = (category == DamageCategory.PHYSICAL) ? StatType.DEFENSE : StatType.SPECIAL_DEFENSE;

        INumber criticalMultiplier = new CriticalHitMultiplier(
                new Gen1CriticalCondition(false),
                new Exactly(2.0)
        );

        return Gen1Damage.builder()
                .level(new Level(Battle::getAttacker))
                .power(basePower)
                .critical(criticalMultiplier)
                .attack(new TargetStat(Battle::getAttacker, attackStat))
                .defense(new TargetStat(Battle::getDefender, defenseStat))
                .stab(new SameTypeAttackBonus(Battle::getAttacker, moveType))
                .type1(new TypeEffectiveness(Battle::getDefender, moveType, 0))
                .type2(new TypeEffectiveness(Battle::getDefender, moveType, 1))
                .build();
    }

    @Override
    public ITypeChart getTypeChart() {
        return Gen1TypeChart.getInstance();
    }

    @Override
    public IMoveRegistry getMoveRegistry() {
        return Gen1MoveRegistry.getInstance();
    }

}
