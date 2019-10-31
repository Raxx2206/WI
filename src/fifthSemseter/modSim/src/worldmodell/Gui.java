package fifthSemseter.modSim.src.worldmodell;


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

public class Gui extends Application {

    private MyClass mc = new MyClass(0.25);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("World modell");

        stage.setScene(new Scene(getView(), 800, 500));
        stage.show();
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
        lc.setTitle("World Model");

        return lc;
    }
}
