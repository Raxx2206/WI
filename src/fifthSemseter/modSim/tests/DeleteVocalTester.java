package fifthSemseter.modSim.tests;

import fifthSemseter.modSim.src.DeleteVocal;

public class DeleteVocalTester {
    public static void main(String[] args) {
        DeleteVocal d = new DeleteVocal("Hochschulcampus Lingen.");
        System.out.println(d.delete1());
        System.out.println(d.delete2());
        System.out.println(d.delete3());

    }
}
