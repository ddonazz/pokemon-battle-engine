package it.andrea.pokemon.model.condition;

public interface ICondition<T> {

    boolean check(T t);

    default ICondition<T> and(ICondition<T> other) {
        return new And<>(this, other);
    }

    default ICondition<T> or(ICondition<T> other) {
        return new Or<>(this, other);
    }

    default ICondition<T> not() {
        return new Not<>(this);
    }
    
}
