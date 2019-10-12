package fifthSemseter.modSim.tests;

import fifthSemseter.modSim.src.PrimeNumber;

public class PrimeNumberTester {

    public static void main(String[] args) {
        PrimeNumber p = new PrimeNumber();

        p.getPrimes(100);

        System.out.println(p);
    }
}
