package fifthSemseter.modSim.src.worldmodell;

public class WorldModellData {
    public final int ITERATION_AMOUNT = 250;
    public final double C;
    public double[] population, ecologicalDamage, consumption, act;

    public WorldModellData(double c) {
        C = c;
        population = new double[ITERATION_AMOUNT];
        ecologicalDamage = new double[ITERATION_AMOUNT];
        consumption = new double[ITERATION_AMOUNT];
        act = new double[ITERATION_AMOUNT];
    }
}
