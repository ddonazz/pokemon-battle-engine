package it.andrea.pokemon.model.number;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.target.ITarget;
import it.andrea.pokemon.utils.StatType;

public class TargetStat implements INumber {

    private final ITarget target;
    private final StatType statType;

    public TargetStat(ITarget target, StatType statType) {
        this.target = target;
        this.statType = statType;
    }

    @Override
    public double evaluate(Battle battle) {
        return target.resolve(battle).getStat(statType);
    }
}
