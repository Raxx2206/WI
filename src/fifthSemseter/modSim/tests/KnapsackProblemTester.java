package fifthSemseter.modSim.tests;


import fifthSemseter.modSim.src.knapsackProblem.FindBestKnapsack;
import fifthSemseter.modSim.src.knapsackProblem.Knapsack;

public class KnapsackProblemTester {

    public static void main(String[] args) {
        FindBestKnapsack findBest = new FindBestKnapsack();

        findBest.newItem(5, 8);
        findBest.newItem(5,8);
        findBest.newItem(6,6);
//        findBest.newItem(8,5);
//        findBest.newItem(10, 10);
//        findBest.newItem(11,5);
//        findBest.newItem(12,10);
//        findBest.newItem(15, 17);
//        findBest.newItem(15,20);
//        findBest.newItem(30, 20);

        findBest.findBest(0, new Knapsack());

        findBest.sort();
        System.out.println(findBest);
    }
}
