package fifthSemseter.modSim.src.springpendulum;

public class PendulumPositionHeavyInNotAir implements PendulumPosition {
    @Override
    public String getName() {
        return "Heavy + not Air";
    }

    @Override
    public double compute(double t) {
        // 5 * x`` + 0.002723 * x` + 20 * x = 0
        return Math.exp(-0.08 * t) * Math.sin(1.9984 * t) + Math.exp(-0.08 * t) * Math.sin(1.9984 * t);
    }
}
