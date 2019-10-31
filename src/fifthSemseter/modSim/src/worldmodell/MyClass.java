package fifthSemseter.modSim.src.worldmodell;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

import java.util.stream.DoubleStream;

public class MyClass {
    public final int ITERATION_AMOUNT = 250;
    public final double C;
    public double[] population, ecologicalDamage, consumption, act;
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
        if (iterationIndex == 250) {
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

    public ObservableList<Series<String, Double>> getData() {
        if (!isComputed)
            compute(0, 1, 0, 0, 0);

        ObservableList<Series<String, Double>> data = FXCollections.observableArrayList();
        data.addAll(arrayToSeries("Poulation", population),
                    arrayToSeries("Ecological Damage", ecologicalDamage),
                    arrayToSeries("Consumotion", consumption),
                    arrayToSeries("Act", act));

        return data;
    }

    public ObservableList<Series<String, Double>> getPopulation() {
        if (!isComputed)
            compute(0, 1, 0, 0, 0);

        return FXCollections.observableArrayList(arrayToSeries("Population", population));
    }

    public ObservableList<Series<String, Double>> getEcologicalDamage() {
        if (!isComputed)
            compute(0, 1, 0, 0, 0);

        return FXCollections.observableArrayList(arrayToSeries("ecologicalDamage", ecologicalDamage));
    }

    public ObservableList<Series<String, Double>> getConsumption() {
        if (!isComputed)
            compute(0, 1, 0, 0, 0);

        return FXCollections.observableArrayList(arrayToSeries("consumption", consumption));
    }

    public ObservableList<Series<String, Double>> getAct() {
        if (!isComputed)
            compute(0, 1, 0, 0, 0);

        return FXCollections.observableArrayList(arrayToSeries("Act", act));
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
