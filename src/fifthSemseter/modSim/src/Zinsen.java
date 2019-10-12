package fifthSemseter.modSim.src;

public class Zinsen {
    private double capital, interestRate;
    private int year;

    public Zinsen(double capital, double interestRate, int year) {
        this.capital = capital;
        this.interestRate = interestRate;
        this.year = year;
    }

    public double calc() {
        double sum = capital;
        System.out.format("Startkapital: %.2f€\n", capital);

        for (int i = 0; i < year; i++) {
            sum *= 1+interestRate;
            System.out.format("%.2f€\n", (sum - capital));
        }
        return sum;
    }
}

