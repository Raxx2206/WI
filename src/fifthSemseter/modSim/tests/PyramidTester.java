package fifthSemseter.modSim.tests;

import fifthSemseter.modSim.src.Pyramid;

public class PyramidTester {

    public static void main(String[] args) {
        Pyramid p = new Pyramid();
        p.simple(5);

        System.out.println();
        System.out.println();

        p.advanced(50);
    }
}
