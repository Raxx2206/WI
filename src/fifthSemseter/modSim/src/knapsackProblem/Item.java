package fifthSemseter.modSim.src.knapsackProblem;

public class Item {
    private static int id = 0;
    private final int ID;
    private final double VALUE, VOLUME;

    public Item(double value, double volume) {
        ID = id++;
        VALUE = value;
        VOLUME = volume;
    }

    public Item(Item i) {
        this.ID = i.ID;
        this.VALUE = i.VALUE;
        this.VOLUME = i.VALUE;
    }

    public int getID() {
        return ID;
    }

    public double getVALUE() {
        return VALUE;
    }

    public double getVOLUME() {
        return VOLUME;
    }

//    @Override
//    public String toString() {
//        return ID+1 + "";
//    }

    @Override
    public String toString() {
        return "Item{" +
                "ID=" + ID +
                ", VALUE=" + VALUE +
                ", VOLUME=" + VOLUME +
                "}\n";
    }
}
