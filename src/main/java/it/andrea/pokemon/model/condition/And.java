package it.andrea.pokemon.model.condition;

public class And<T> implements ICondition<T> {

    private final ICondition<T> left;
    private final ICondition<T> right;

    public And(ICondition<T> left, ICondition<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean check(T t) {
        return left.check(t) && right.check(t);
    }
}
