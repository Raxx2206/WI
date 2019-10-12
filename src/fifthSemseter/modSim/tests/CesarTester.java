package fifthSemseter.modSim.tests;

import fifthSemseter.modSim.src.CesarEncoding;

public class CesarTester {

    public static void main(String[] args) {
        CesarEncoding c = new CesarEncoding();

        System.out.println(c.cipher("abAByzYZ adfgp'i", 1));
    }
}
