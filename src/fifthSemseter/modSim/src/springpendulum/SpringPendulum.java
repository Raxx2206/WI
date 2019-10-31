package fifthSemseter.modSim.src.springpendulum;

import org.math.plot.Plot3DPanel;

import javax.swing.*;

public class SpringPendulum {
    final static double TIME_START = 1;
    final static double TIME_INCREMENT = 0.1;
    final static double TIME_END = 500;
    final static Plot3DPanel plot = new Plot3DPanel();
    static double zValue = 0;

    private static void simulatePendulum(PendulumPosition pp) {
        final int arraySize = (int) Math.round((TIME_END - TIME_START) / TIME_INCREMENT);
        double[] x = new double[arraySize];
        double[] z = new double[arraySize];
        double[] y = new double[arraySize];

        double position = 1;
        double t = TIME_START;

        for (int i = 0; i < arraySize; i++, t += TIME_INCREMENT) {
            x[i] = t;
            z[i] = zValue;
            y[i] = position;

            position = pp.compute(t);
            System.out.println("Time: " + t + "\t Position: " + position);
        }

        plot.addLinePlot(pp.getName(), x, y, z);
        zValue++;
    }

    public static void main(String[] args) {
        plot.addLegend("SOUTH");

//        simulatePendulum(new PendulumPositionHeavyInAir());
        simulatePendulum(new PendulumPositionLightInAir());
        simulatePendulum(new PendulumPositionMediumInAir());
        simulatePendulum(new PendulumPositionHeavyInAir());

        JFrame frame = new JFrame("Plotting the pendulum positions");
        frame.setSize(600, 600);
        frame.setContentPane(plot);
        frame.setVisible(true);
    }
}
