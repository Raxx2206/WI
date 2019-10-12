package fifthSemseter.modSim.tests;

import fifthSemseter.modSim.src.Zinsen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZinsenTester {

    public static void main(String[] args) {
        double capital, interestRate;
        int year;
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        do {
            try {
                System.out.print("Startkapital: ");
                String s = bfr.readLine();
                capital = Double.parseDouble(s);

                System.out.print("Zinsen: ");
                s = bfr.readLine();
                interestRate = Double.parseDouble(s);

                System.out.print("Jahre: ");
                s = bfr.readLine();
                year = Integer.parseInt(s);

            } catch (IOException | NumberFormatException q) {
                System.out.println("Geben sie eine gueltige Zahl ein!");
                continue;
            }

            break;
        } while (true);

        // Zinsen z = new Zinsen(1000, 0.03, 10);
        Zinsen z = new Zinsen(capital, interestRate, year);
        System.out.printf("Endkapital: %.2f", z.calc());
    }
}
