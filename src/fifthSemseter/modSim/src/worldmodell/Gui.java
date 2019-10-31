package fifthSemseter.modSim.src.worldmodell;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Gui extends Application {

    private MyClass mc = new MyClass(0.3);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("World modell");
        StackPane pane = new StackPane();
        pane.getChildren().add(getLineChart());
        stage.setScene(new Scene(pane, 800, 500));
        stage.show();
    }

    public LineChart<CategoryAxis, NumberAxis> getLineChart() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart lc = new LineChart<>(xAxis, yAxis);
        lc.setData(mc.getData());
        lc.setTitle("Line chart on random data");
        return lc;
    }
}
