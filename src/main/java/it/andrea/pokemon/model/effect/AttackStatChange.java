package it.andrea.pokemon.model.effect;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.number.INumber;
import it.andrea.pokemon.model.target.ITarget;
import it.andrea.pokemon.utils.StatType;

public class AttackStatChange implements IEffect {

    private final ITarget target;
    private final INumber stages;
    private final StatType statType;

    public AttackStatChange(ITarget target, INumber stages) {
        this(target, stages, StatType.ATTACK);
    }

    public AttackStatChange(ITarget target, INumber stages, StatType statType) {
        this.target = target;
        this.stages = stages;
        this.statType = statType;
    }

    @Override
    public void apply(Battle battle) {
        int stageDelta = (int) Math.round(stages.evaluate(battle));
        target.resolve(battle).updateStatStages(statType, stageDelta);

        String battlerName = target.resolve(battle).getName();
        if (stageDelta < 0) {
            System.out.printf("%s's %s fell!%n", battlerName, statType);
        } else if (stageDelta > 0) {
            System.out.printf("%s's %s rose!%n", battlerName, statType);
        }
    }
}
