package fifthSemseter.modSim.src.knapsackProblem;

import java.util.Vector;

public class FindBestKnapsack {
    private Vector<Item> items = new Vector<>();
    private Vector<Knapsack> knapsacks = new Vector<>();

    public void newItem(double value, double volume) {
        newItem(new Item(value, volume));
    }

    public void newItem(Item i) {
        items.add(i);
    }

    public void findBest(int itemPos, Knapsack knapsack) {
        if (itemPos >= items.size()) {
            knapsacks.add(knapsack);
            return;
        }

        Knapsack newKnapsack = new Knapsack(knapsack);

        if (knapsack.add(items.get(itemPos)))
            findBest(itemPos + 1, knapsack);

        findBest(itemPos + 1, newKnapsack);

    }

    public void sort() {
        knapsacks.sort(Knapsack::compareTo);
    }

    @Override
    public String toString() {
        return "FindBestKnapsack{" +
                "knapsacks=" + knapsacks +
                '}';
    }
}
