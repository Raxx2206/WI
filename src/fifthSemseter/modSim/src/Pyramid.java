package fifthSemseter.modSim.src;

public class Pyramid {

    public void simple(int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print("*");

            for (int j = 0; j < row - i; j++)
                System.out.print(" ");

            System.out.println();
        }
    }

    public void advanced(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < row - i; j++) System.out.print("_");

            for (int j = 0; j < 2 * i - 1; j++) System.out.print("*");

            for (int j = 0; j < row - i; j++) System.out.print("_");

            System.out.println();
        }
    }
}
