package fifthSemseter.modSim.src.worldmodell_old;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.stream.DoubleStream;

public class Gui extends Application {

    private MyClass mc = new MyClass(0.22);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("World model");
        stage.setScene(new Scene(getView(), 800, 500));
        stage.show();

        DoubleStream.of(mc.getPopulation()).forEach(System.out::println);
    }

    public VBox getView() {
        VBox pane = new VBox();
        pane.getStylesheets().add(getClass().getResource("root.css").toExternalForm());
        ArrayList<Series<String, Double>> data = mc.getData();

        data.forEach(ele -> pane.getChildren().add(getLineChart(ele)));

        return pane;
    }

    public LineChart<CategoryAxis, NumberAxis> getLineChart(Series<String, Double> data) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        LineChart lc = new LineChart<>(xAxis, yAxis);
        lc.setData(FXCollections.observableArrayList(data));
        lc.setTitle(data.getName());

        return lc;
    }
}
