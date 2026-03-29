package it.andrea.pokemon.model.move;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.battle.Battler;
import it.andrea.pokemon.model.condition.ICondition;

public class WithApplicability implements IMove {

    private ICondition<Battler> condition;
    private IMove wrappedMove;

    public WithApplicability(ICondition<Battler> condition, IMove wrappedMove) {
        this.condition = condition;
        this.wrappedMove = wrappedMove;
    }

    @Override
    public void execute(Battle battle) {
        if (condition.check(battle.getAttacker())) {
            wrappedMove.execute(battle);
        } else {
            System.out.println("");
        }
    }
}
