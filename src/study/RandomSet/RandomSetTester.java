package study.RandomSet;

public class RandomSetTester {

    public static void main(String[] args) {
        RandomSet rs1 = new RandomSet(5, 10);
        RandomSet rs2 = new RandomSet(5, 10);

        System.out.println(rs1);
        System.out.println(rs2);

        System.out.println("\n-------\nVereinigung");
        System.out.println(RandomSet.union(rs1, rs2));

        System.out.println("-------\nSchnittmenge");
        System.out.println(RandomSet.intersection(rs1, rs2));

        System.out.println("-------\nDifferenze");
        System.out.println(RandomSet.difference(rs1, rs2));


        System.out.println("\n-------\nVereinigung");
        System.out.println(RandomSet.union(rs2, rs1));

        System.out.println("-------\nSchnittmenge");
        System.out.println(RandomSet.intersection(rs2, rs1));

        System.out.println("-------\nDifferenze");
        System.out.println(RandomSet.difference(rs2, rs1));
    }
}
