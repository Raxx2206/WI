package fifthSemseter.modSim.src.knapsackProblem;

import java.util.Vector;

public class Knapsack implements Comparable<Knapsack> {
    private static int id = 0;

    public final int ID;
    public final double MAX_VOLUME;
    private Vector<Item> items;
    private double knapsackValue = .0, knapsackVolume = .0;
    private boolean isRefilled = true;

    public Knapsack() {
        ID = id++;
        MAX_VOLUME = 30.0;
        items = new Vector<>();
    }

    public Knapsack(double maxVolume) {
        ID = id++;
        MAX_VOLUME = maxVolume;
        items = new Vector<>();
    }

    public Knapsack(Knapsack k) {
        ID = id++;
        MAX_VOLUME = k.MAX_VOLUME;

        items = new Vector<>(k.items);
        calculateKnapsack();
    }

    public boolean add(double value, double volume) {
        return add(new Item(value, volume));
    }

    public boolean add(Item i) {
        if (Double.compare((getVolume() + i.getVOLUME()), MAX_VOLUME) <= 0) {
            isRefilled = true;
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
                ", MAX=" + MAX_VOLUME +
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

        return Double.compare(o.getValue(), getValue());
    }
}
