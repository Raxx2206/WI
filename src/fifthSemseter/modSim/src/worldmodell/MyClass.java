package fifthSemseter.modSim.src.worldmodell;

import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.DoubleStream;

public class MyClass {
    public final int ITERATION_AMOUNT = 200;
    public final double C;
    public Map<String, Double[]> systemParameter;
    private double[] population, ecologicalDamage, consumption, act;
    private boolean isComputed = false;

    public MyClass(double c) {
        C = c;

        population = new double[ITERATION_AMOUNT];
        ecologicalDamage = new double[ITERATION_AMOUNT];
        consumption = new double[ITERATION_AMOUNT];
        act = new double[ITERATION_AMOUNT];
    }

    /**
     * @param v              start value for population
     * @param l              start value for ecologicalDamage
     * @param k              start value for consumption
     * @param h              start value for act
     * @param iterationIndex time
     */
    private void compute(double v, double l, double k, double h, int iterationIndex) {
        if (iterationIndex == ITERATION_AMOUNT) {
            isComputed = true;
            return;
        }

        population[iterationIndex] = -0.1 * l + 0.3 * k - 0.1 * h;
        ecologicalDamage[iterationIndex] = v + k;
        consumption[iterationIndex] = 1.1 * l - h;
        act[iterationIndex] = C * l;

        compute(population[iterationIndex],
                ecologicalDamage[iterationIndex],
                consumption[iterationIndex],
                act[iterationIndex],
                ++iterationIndex);
    }

    public void compute() {
        compute(0, 1, 0, 0, 0);
    }

    public ArrayList<Series<String, Double>> getData() {
        if (!isComputed)
            compute();

        ArrayList<Series<String, Double>> data = new ArrayList<>();
        data.add(arrayToSeries("Poulation (v)", population));
        data.add(arrayToSeries("Ecological Damage (l)", ecologicalDamage));
        data.add(arrayToSeries("Consumption (k)", consumption));
        data.add(arrayToSeries("Act (h)", act));

        return data;
    }

    public double[] getPopulation() {
        if (!isComputed)
            compute();

        return population;
    }

    public double[] getEcologicalDamage() {
        if (!isComputed)
            compute();

        return ecologicalDamage;
    }

    public double[] getConsumption() {
        if (!isComputed)
            compute();

        return consumption;
    }

    public double[] getAct() {
        if (!isComputed)
            compute();

        return act;
    }

    private Series<String, Double> arrayToSeries(String name, double[] array) {
        var series = new Series<String, Double>();
        series.setName(name);

        DoubleStream.of(array)
                    .forEach(value -> series.getData()
                                            .add(new XYChart.Data<>(Integer.toString(series.getData().size()), value)));

        return series;
    }
}
