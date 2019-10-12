package fifthSemseter.modSim.src;

import java.util.Vector;

public class PrimeNumber {
    private static final int firstDivider = 2;
    private Vector<Integer> primeNumber;

    public Vector<Integer> getPrimes(int amount)
    {
        if (primeNumber == null)
            primeNumber = new Vector<>();
        else
            return primeNumber;

        int numberToCheck = firstDivider;
        while (primeNumber.size() < amount) {

            if (isPrime(numberToCheck))
                primeNumber.add(numberToCheck);

            numberToCheck++;
        }

        return primeNumber;
    }

    private boolean isPrime(int numberToCheck) {
        for (int divider = 2; divider <= Math.sqrt(numberToCheck); divider++) {
            if (numberToCheck % divider == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        int size = primeNumber.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(i+1).append(". ").append(primeNumber.get(i)).append('\n');
        }

        return stringBuilder.toString();
    }

}
