package fifthSemseter.modSim.src.knapsackProblem;

import java.util.ArrayList;

public class Knapsack {
    private ArrayList<Item> items;
    private double value = .0, volume = .0;
    private boolean isRefilledValue = true, isRefilledVolume = true;

    public Knapsack() {
        items = new ArrayList<>();
    }

    public Knapsack(Knapsack k) {
        items = new ArrayList<>();

        for (Item i : k.items) if (i != null) items.add(new Item(i));
    }

    public void add(double value, double volume) {
        add(new Item(value, volume));
        isRefilledValue = true;
        isRefilledVolume = true;
    }

    public void add(Item i) {
        items.add(i);
    }

    public double calculateValueSum() {
        if (isRefilledValue) {
            items.forEach(item -> value += item.getVALUE());
            isRefilledValue = false;
        }

        return value;
    }

    public double calculateVolumeSum() {
        if (isRefilledVolume) {
            items.forEach(item -> volume += item.getVOLUME());
            isRefilledVolume = false;
        }

        return volume;
    }

    @Override
    public String toString() {
        return "Knapsack{" +
                "size: " + items.size() + " | " +
                "items=" + items +
                '}';
    }
}
