package it.andrea.pokemon.model.number;

import it.andrea.pokemon.battle.Battle;

public class Gen1Damage implements INumber {

    private final INumber level;
    private final INumber critical;
    private final INumber power;
    private final INumber attack;
    private final INumber defense;
    private final INumber stab;
    private final INumber type1;
    private final INumber type2;

    private Gen1Damage(INumber level, INumber critical, INumber power, INumber attack, INumber defense, INumber stab, INumber type1, INumber type2) {
        this.level = level;
        this.critical = critical;
        this.power = power;
        this.attack = attack;
        this.defense = defense;
        this.stab = stab;
        this.type1 = type1;
        this.type2 = type2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private INumber level;
        private INumber critical;
        private INumber power;
        private INumber attack;
        private INumber defense;
        private INumber stab;
        private INumber type1;
        private INumber type2;

        public Builder level(INumber level) {
            this.level = level;
            return this;
        }

        public Builder critical(INumber critical) {
            this.critical = critical;
            return this;
        }

        public Builder power(INumber power) {
            this.power = power;
            return this;
        }

        public Builder attack(INumber attack) {
            this.attack = attack;
            return this;
        }

        public Builder defense(INumber defense) {
            this.defense = defense;
            return this;
        }

        public Builder stab(INumber stab) {
            this.stab = stab;
            return this;
        }

        public Builder type1(INumber type1) {
            this.type1 = type1;
            return this;
        }

        public Builder type2(INumber type2) {
            this.type2 = type2;
            return this;
        }

        public Gen1Damage build() {
            return new Gen1Damage(level, critical, power, attack, defense, stab, type1, type2);
        }
    }

    @Override
    public double evaluate(Battle battle) {
        double level = this.level.evaluate(battle);
        double critical = this.critical.evaluate(battle);
        double power = this.power.evaluate(battle);
        double attack = this.attack.evaluate(battle);
        double defense = this.defense.evaluate(battle);

        // 1. Quirk della Gen 1: se Attacco o Difesa superano 255, vengono divisi per 4
        if (attack > 255 || defense > 255) {
            attack = Math.floor(attack / 4);
            defense = Math.floor(defense / 4);
        }

        // 2. Quirk della Gen 1: se la difesa è 0, il gioco andava in softlock.
        // Possiamo simulare l'errore matematico o lanciare un'eccezione
        if (defense == 0) {
            throw new ArithmeticException("Gen 1 Softlock: Divisione per 0 (Difesa = 0)");
        }

        double stab = this.stab.evaluate(battle);
        double t1 = this.type1.evaluate(battle);
        double t2 = this.type2.evaluate(battle);

        // 3. Calcolo base con arrotondamenti per difetto (tipici dei giochi originali)
        // ((2 * Level * Critical / 5) + 2)
        double baseDamage = Math.floor((2 * level * critical) / 5) + 2;

        // * Power * (A / D) / 50 + 2
        baseDamage = Math.floor(baseDamage * power * (attack / defense)) / 50 + 2;

        // 4. Moltiplicatori
        double finalDamage = Math.floor(baseDamage * stab); // STAB (internamente moltiplicazione x 1.5)
        finalDamage = Math.floor(finalDamage * t1 * t2); // Efficacia dei tipi

        // Se il danno calcolato finora è 0, la mossa fallisce
        if (finalDamage == 0) {
            return 0; // "the move is stated to have missed"
        }

        // 5. Fattore Random (solo se il danno finora è maggiore di 1)
        if (finalDamage > 1) {
            // numero casuale tra 217 e 255 inclusi
            int r = 217 + (int) (Math.random() * (255 - 217 + 1));
            finalDamage = Math.floor((finalDamage * r) / 255);
        }

        return finalDamage;
    }


}
