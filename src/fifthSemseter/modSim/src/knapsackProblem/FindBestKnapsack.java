package fifthSemseter.modSim.src.knapsackProblem;

import java.util.Vector;

public class FindBestKnapsack {
    private Vector<Item> items = new Vector<>();

    public void newItem(double value, double volume) {
        newItem(new Item(value, volume));
    }

    public void newItem(Item i) {
        items.add(i);
    }

    public Knapsack findBest(int sackPos, Knapsack knapsack) {
        if (sackPos < items.size()) {
            if (knapsack == null) knapsack = new Knapsack();

            knapsack.add(items.get(sackPos));

            findBest(++sackPos, knapsack);

            findBest(++sackPos, null);
        }

        System.out.println(knapsack);

        return null;
    }
}
