package fifthSemseter.modSim.src.foresterWorldModel;

import java.util.stream.IntStream;

public class Data {
    public final int ITERATION_SIZE;
    public final double C;

    private double[] populationDelta, ecologicalDamageDelta, consumptionDelta, actDelta;
    private double[] populationSum, ecologicalDamageSum, consumptionSum, actSum;
    private boolean isComputed = false;

    public Data(double c) {
        C = c;
        ITERATION_SIZE = 250;

        init();
    }

    public Data(double c, int iterationSize) {
        C = c;
        ITERATION_SIZE = iterationSize;

        init();
    }

    private void init() {
        populationDelta = new double[ITERATION_SIZE];
        ecologicalDamageDelta = new double[ITERATION_SIZE];
        consumptionDelta = new double[ITERATION_SIZE];
        actDelta = new double[ITERATION_SIZE];

        populationSum = new double[ITERATION_SIZE + 1];
        ecologicalDamageSum = new double[ITERATION_SIZE + 1];
        consumptionSum = new double[ITERATION_SIZE + 1];
        actSum = new double[ITERATION_SIZE + 1];
    }

    /**
     * @param v start value for population
     * @param l start value for ecological damage
     * @param k start value for consumption
     * @param h start value for act
     */
    public void compute(double v, double l, double k, double h) {
        computeDelta(v, l, k, h);
        computeSum(v, l, k, h);
    }

    private void computeDelta(double v, double l, double k, double h, int iterationIndex) {
        if (iterationIndex == ITERATION_SIZE) {
            isComputed = true;
            return;
        }

        populationDelta[iterationIndex] = -0.1 * l + 0.3 * k - 0.1 * h;
        ecologicalDamageDelta[iterationIndex] = v + k;
        consumptionDelta[iterationIndex] = 1.1 * l - h;
        actDelta[iterationIndex] = C * l;

        computeDelta(populationDelta[iterationIndex],
                ecologicalDamageDelta[iterationIndex],
                consumptionDelta[iterationIndex],
                actDelta[iterationIndex],
                ++iterationIndex);
    }

    public void computeDelta(double v, double l, double k, double h) {
        computeDelta(v, l, k, h, 0);
    }

    public void computeSum(double v, double l, double k, double h) {
        if (!isComputed)
            computeDelta(v, l, k, h, 0);

        IntStream.range(0, ITERATION_SIZE).forEachOrdered(i -> {
            populationSum[i + 1] = populationSum[i] + populationDelta[i];
            ecologicalDamageSum[i + 1] = ecologicalDamageSum[i] + ecologicalDamageDelta[i];
            consumptionSum[i + 1] = consumptionSum[i] + consumptionDelta[i];
            actSum[i + 1] = actSum[i] + actDelta[i];
        });
    }

    public double[] getPopulationDelta() throws Exception {
        if (!isComputed)
            throw new Exception("Compute data first!");

        return populationDelta;
    }

    public double[] getEcologicalDamageDelta() throws Exception {
        if (!isComputed)
            throw new Exception("Compute data first!");

        return ecologicalDamageDelta;
    }

    public double[] getConsumptionDelta() throws Exception {
        if (!isComputed)
            throw new Exception("Compute data first!");

        return consumptionDelta;
    }

    public double[] getActDelta() throws Exception {
        if (!isComputed)
            throw new Exception("Compute data first!");

        return actDelta;
    }

    public double[] getPopulationSum() throws Exception {
        if (!isComputed)
            throw new Exception("Compute data first!");

        return populationSum;
    }

    public double[] getEcologicalDamageSum() throws Exception {
        if (!isComputed)
            throw new Exception("Compute data first!");

        return ecologicalDamageSum;
    }

    public double[] getConsumptionSum() throws Exception {
        if (!isComputed)
            throw new Exception("Compute data first!");

        return consumptionSum;
    }

    public double[] getActSum() throws Exception {
        if (!isComputed)
            throw new Exception("Compute data first!");

        return actSum;
    }
}
