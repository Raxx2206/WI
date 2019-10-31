package fifthSemseter.modSim.src.springpendulum;

public class PendulumPositionMediumInAir implements PendulumPosition {
    @Override
    public String getName() {
        return "Medium + Air";
    }

    @Override
    public double compute(double t) {
        // 5 * x`` + 0.002723 * x` + 20 * x = 0
        return Math.exp(-0.002723 * t) * Math.sin(6.32455 * t) + Math.exp(-0.002723 * t) * Math.cos(6.32455 * t);
    }
}
