package fifthSemseter.modSim.src.foresterWorldModel;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.stream.IntStream;

public class Gui extends Application {
    private int iterationSize = 250;
    private double c = 0.41;
    private double startValuePopu = .0;
    private double startValueEco = 1.0;
    private double startValueCons = .0;
    private double startValueAct = .0;

    private Data data;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        data = new Data(c, iterationSize);
        data.compute(startValuePopu, startValueEco, startValueCons, startValueAct);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("World Model | Forester");
        primaryStage.setScene(new Scene(getScene(), 900, 600));
        primaryStage.show();
    }

    private Parent getScene() {
        HBox population = new HBox();
        HBox ecologicalDamage = new HBox();
        HBox consumption = new HBox();
        HBox act = new HBox();

        try {
            population.getChildren().addAll(createLineChart("Population", data.getPopulationDelta(), data.getPopulationSum()));
            ecologicalDamage.getChildren().addAll(createLineChart("Ecological Damage", data.getEcologicalDamageDelta(), data.getEcologicalDamageSum()));
            consumption.getChildren().addAll(createLineChart("Consumption", data.getConsumptionDelta(), data.getConsumptionSum()));
            act.getChildren().addAll(createLineChart("Act", data.getActDelta(), data.getActSum()));

        } catch (Exception e) {
            data.compute(startValuePopu, startValueEco, startValueCons, startValueAct);
            return getScene();
        }

        VBox vBox = new VBox(population, ecologicalDamage, consumption, act);
        vBox.getStylesheets().add(getClass().getResource("root.css").toExternalForm());

        return vBox;
    }

    private LineChart<Number, Number> createLineChart(String name, double[] delta, double[] sum) {
        LineChart<Number, Number> lineChart = new LineChart<>(new NumberAxis(), new NumberAxis());
        lineChart.setTitle(name);

        XYChart.Series<Number, Number> seriesDelta = new XYChart.Series<>();
        XYChart.Series<Number, Number> seriesSum = new XYChart.Series<>();

        IntStream.range(0, data.ITERATION_SIZE).forEachOrdered(i -> {
            seriesDelta.getData().add(new XYChart.Data<>(i, delta[i]));
            seriesSum.getData().add(new XYChart.Data<>(i, sum[i]));
        });

        seriesDelta.setName("Delta");
        seriesSum.setName("Sum");

        lineChart.getData().addAll(seriesDelta, seriesSum);
        HBox.setHgrow(lineChart, Priority.ALWAYS);

        return lineChart;
    }
}
