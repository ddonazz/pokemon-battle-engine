package it.andrea.pokemon.battle;

public class PokemonStats {
    private final int maxHp;
    private final int attack;
    private final int defense;
    private final int specialAttack;
    private final int specialDefense;
    private final int speed;

    private PokemonStats(int maxHp, int attack, int defense, int specialAttack, int specialDefense, int speed) {
        this.maxHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getSpeed() {
        return speed;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getDefense() {
        return defense;
    }

    public int getAttack() {
        return attack;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public static class Builder {
        private int maxHp;
        private int attack;
        private int defense;
        private int specialAttack;
        private int specialDefense;
        private int speed;

        public Builder maxHp(int maxHp) {
            this.maxHp = maxHp;
            return this;
        }

        public Builder attack(int attack) {
            this.attack = attack;
            return this;
        }

        public Builder defense(int defense) {
            this.defense = defense;
            return this;
        }

        public Builder specialAttack(int specialAttack) {
            this.specialAttack = specialAttack;
            return this;
        }

        public Builder specialDefense(int specialDefense) {
            this.specialDefense = specialDefense;
            return this;
        }

        public Builder speed(int speed) {
            this.speed = speed;
            return this;
        }

        public PokemonStats build() {
            return new PokemonStats(maxHp, attack, defense, specialAttack, specialDefense, speed);
        }
    }
}