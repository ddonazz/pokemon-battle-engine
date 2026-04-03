package it.andrea.pokemon.model.rules.gen1;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.condition.ICondition;
import it.andrea.pokemon.utils.StatType;

public class Gen1CriticalCondition implements ICondition<Battle> {

    private final boolean highCritRatio;

    public Gen1CriticalCondition(boolean highCritRatio) {
        this.highCritRatio = highCritRatio;
    }

    @Override
    public boolean check(Battle battle) {
        int speed = battle.getAttacker().getStat(StatType.SPEED);

        int threshold = speed / 2;

        if (highCritRatio) {
            threshold *= 8;
        }

        threshold = Math.min(threshold, 255);

        int randomByte = (int) (Math.random() * 256);

        return randomByte < threshold;
    }

}
