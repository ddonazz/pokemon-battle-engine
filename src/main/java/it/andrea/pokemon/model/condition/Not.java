package it.andrea.pokemon.model.condition;

public class Not<T> implements ICondition<T> {

    private final ICondition<T> condition;

    public Not(ICondition<T> condition) {
        this.condition = condition;
    }

    @Override
    public boolean check(T t) {
        return !condition.check(t);
    }
}
