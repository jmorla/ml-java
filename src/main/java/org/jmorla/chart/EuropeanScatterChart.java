package org.jmorla.chart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class EuropeanScatterChart extends Application {

    private final CategoryAxis xAxis = new CategoryAxis();
    private final NumberAxis yAxis = new NumberAxis(1000, 3000, 200);
    @Override
    public void start(Stage primaryStage) {
        var scatterChart = new ScatterChart<>(xAxis, yAxis);

        scatterChart.setTitle("LeBron's scoring history");
        xAxis.setLabel("Season");
        yAxis.setLabel("Score");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("2003-2004", 1654));
        series.getData().add(new XYChart.Data<>("2004-2005", 2175));
        series.getData().add(new XYChart.Data<>("2005-2006", 2478));
        series.getData().add(new XYChart.Data<>("2006-2007", 2132));
        series.getData().add(new XYChart.Data<>("2007-2008", 2250));
        series.getData().add(new XYChart.Data<>("2008-2009", 2304));
        series.getData().add(new XYChart.Data<>("2009-2010", 2258));
        series.getData().add(new XYChart.Data<>("2010-2011", 2111));
        series.getData().add(new XYChart.Data<>("2011-2012", 1683));
        series.getData().add(new XYChart.Data<>("2012-2013", 2036));
        series.getData().add(new XYChart.Data<>("2013-2014", 2089));
        series.getData().add(new XYChart.Data<>("2014-2015", 1743));
        series.getData().add(new XYChart.Data<>("2015-2016", 1920));
        series.getData().add(new XYChart.Data<>("2016-2017", 1954));
        series.getData().add(new XYChart.Data<>("2017-2018", 2251));
        series.getData().add(new XYChart.Data<>("2018-2019", 1505));
        series.getData().add(new XYChart.Data<>("2019-2020", 1698));
        series.getData().add(new XYChart.Data<>("2020-2021", 1126));
        series.getData().add(new XYChart.Data<>("2021-2022", 1695));
        series.getData().add(new XYChart.Data<>("2022-2023", 1590));
        series.getData().add(new XYChart.Data<>("2023-0024", 1000));

        scatterChart.getData().add(series);

        Scene scene = new Scene(scatterChart, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
