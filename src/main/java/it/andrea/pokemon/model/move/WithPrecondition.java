package it.andrea.pokemon.model.move;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.condition.ICondition;

public class WithPrecondition implements IMove {

    private final ICondition<Battle> condition;
    private final IMove wrappedMove;

    public WithPrecondition(ICondition<Battle> condition, IMove wrappedMove) {
        this.condition = condition;
        this.wrappedMove = wrappedMove;
    }

    @Override
    public String getName() {
        return wrappedMove.getName();
    }

    @Override
    public void execute(Battle battle) {
        if (condition.check(battle)) {
            wrappedMove.execute(battle);
        } else {
            System.out.println("But it failed!");
        }
    }
}
