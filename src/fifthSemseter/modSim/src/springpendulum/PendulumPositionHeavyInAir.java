package fifthSemseter.modSim.src.springpendulum;

public class PendulumPositionHeavyInAir implements PendulumPosition {
    @Override
    public String getName() {
        return "Heavy + Air";
    }

    @Override
    public double compute(double t) {
        // 5 * x`` + 0.002723 * x` + 20 * x = 0
        return Math.exp(-0.002723 * t) * Math.sin(2 * t) + Math.exp(-0.002723 * t) * Math.cos(2 * t);
    }
}
