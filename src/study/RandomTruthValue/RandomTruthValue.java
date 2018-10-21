package study.RandomTruthValue;

import java.util.Random;

public class RandomTruthValue {
    private static Random rnd = new Random();
    private final boolean VALUE;

    public RandomTruthValue() {
        VALUE = rnd.nextBoolean();
    }

    public RandomTruthValue(boolean value) {
        this.VALUE = value;
    }

    public RandomTruthValue(RandomTruthValue rtv) {
        this.VALUE = rtv.VALUE;
    }

    RandomTruthValue and(RandomTruthValue rtv) {
        return new RandomTruthValue(VALUE && rtv.VALUE);
    }

    RandomTruthValue or(RandomTruthValue rtv) {
        return new RandomTruthValue(VALUE || rtv.VALUE);
    }

    RandomTruthValue not() {
        return new RandomTruthValue(!VALUE);
    }

    public String toString() {
        return VALUE ? "TRUE" : "FALSE";
    }
}
