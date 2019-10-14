package fifthSemseter.modSim.src.knapsackProblem;

import java.util.ArrayList;
import java.util.Objects;

public class Knapsack implements Comparable<Knapsack> {
    private static int id = 0;

    public final int ID;
    public final double MAX_VOLUME;
    private ArrayList<Item> items;
    private double knapsackValue = .0, knapsackVolume = .0;
    private boolean isRefilled = true;

    public Knapsack() {
        items = new ArrayList<>();
        ID = id++;
        MAX_VOLUME = 30.0;
    }

    public Knapsack(double maxVolume) {
        items = new ArrayList<>();
        ID = id++;
        MAX_VOLUME = maxVolume;
    }

    public Knapsack(Knapsack k) {
        items = new ArrayList<>();
        ID = id++;
        MAX_VOLUME = k.MAX_VOLUME;

        k.items.stream().filter(Objects::nonNull).forEach(i -> items.add(new Item(i)));
    }

    public boolean add(double value, double volume) {
        return add(new Item(value, volume));
    }

    public boolean add(Item i) {
        isRefilled = true;

        if (knapsackVolume + i.getVOLUME() <= MAX_VOLUME) {
            items.add(i);
            return true;
        }

        return false;
    }

    public double getValue() {
        if (isRefilled)
            calculateKnapsack();

        return knapsackValue;
    }

    public double getVolume() {
        if (isRefilled)
            calculateKnapsack();

        return knapsackVolume;
    }

    private void calculateKnapsack() {
        knapsackVolume = .0;
        knapsackValue = .0;

        items.forEach(item -> {
            knapsackValue += item.getVALUE();
            knapsackVolume += item.getVOLUME();
        });

        isRefilled = false;
    }

//    @Override
//    public String toString() {
//        return "Knapsack[ " + items + " ]\n";
//    }

    @Override
    public String toString() {
        calculateKnapsack();

        return "Knapsack{" +
                "ID=" + ID +
                ", items=" + items +
                ", knapsackValue=" + knapsackValue +
                ", knapsackVolume=" + knapsackVolume +
                "}\n\n";
    }

    @Override
    public int compareTo(Knapsack o) {
//        if (knapsackValue == o.knapsackValue)
//            return 0;
//        else if (knapsackValue > o.knapsackValue)
//            return 1;
//        else
//            return -1;

        return Double.compare(knapsackValue, o.knapsackValue);
    }
}
