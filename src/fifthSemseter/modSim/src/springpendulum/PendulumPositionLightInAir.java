package fifthSemseter.modSim.src.springpendulum;

public class PendulumPositionLightInAir implements PendulumPosition {
    @Override
    public String getName() {
        return "Light + Air";
    }

    @Override
    public double compute(double t) {
        // 5 * x`` + 0.002723 * x` + 20 * x = 0
        return Math.exp(-0.12615 * t) * Math.sin(44.7212 * t) + Math.exp(-0.13615 * t) * Math.cos(44.7212 * t);
    }
}
