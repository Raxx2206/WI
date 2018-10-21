package study.RandomTruthValue;

public class RandomTruthValueTester {

    public static void main(String[] args) {
        RandomTruthValue a = new RandomTruthValue();
        RandomTruthValue b = new RandomTruthValue();
        RandomTruthValue c = new RandomTruthValue();

        RandomTruthValue v1 = a.and(b.or(c));
        RandomTruthValue v2 = a.and(b).or(a.and(c));

        RandomTruthValue v3 = a.and(b).not();
        RandomTruthValue v4 = a.not().or(b.not());

        System.out.printf("a:                       %s\n", a);
        System.out.printf("b:                       %s\n", b);
        System.out.printf("a:                       %s\n", c);
        System.out.println("--Distributiv--");
        System.out.printf("a and (b or c):          %s\n", v1);
        System.out.printf("(a and b) or (a and c):  %s\n", v2);
        System.out.println("--DeMorgan--");
        System.out.printf("!(a and b):              %s\n", v3);
        System.out.printf("!a or !b:                %s\n", v4);

    }
}
