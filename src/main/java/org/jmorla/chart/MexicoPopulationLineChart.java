package org.jmorla.chart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import org.apache.commons.math3.stat.regression.SimpleRegression;

import java.text.NumberFormat;

public class MexicoPopulationLineChart extends Application {

    private final double[][] mexicoPopulation = new double[][]{
            {1955, 31452141},
            {1960, 36268055},
            {1965, 42737991},
            {1970, 50289306},
            {1975, 58691882},
            {1980, 67705186},
            {1985, 74872006},
            {1990, 81720428},
            {1995, 89969572},
            {2000, 97873442},
            {2005, 105442402},
            {2010, 112532401},
            {2015, 120149897},
            {2020, 125998302},
            {2022, 127504125},
            {2023, 128455567}
    };

    double[] predictionYears = {1955, 1960, 1965, 1970, 1975, 1980, 1985, 1990, 1995, 2000, 2005, 2010, 2015, 2020, 2022, 2023, 2024, 2025, 2026, 2027, 2028, 2029, 2030};

    @Override
    public void start(Stage primaryStage) {
        SimpleRegression regression = new SimpleRegression();
        regression.addData(mexicoPopulation);

        NumberFormat yearFormat = NumberFormat.getNumberInstance();
        yearFormat.setMaximumFractionDigits(0);
        yearFormat.setGroupingUsed(false);

        NumberFormat populationFormat = NumberFormat.getNumberInstance();
        populationFormat.setMaximumFractionDigits(0);

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis(20_000_000, 150_000_000, 10_000_000);
        var series = new XYChart.Series<String, Number>();

        for (var population: mexicoPopulation) {
            series.getData().add(new XYChart.Data<>(yearFormat.format(population[0]), population[1]));
        }

        var predictionSeries = new XYChart.Series<String, Number>();

        for (var year: predictionYears) {
            predictionSeries.getData().add(new XYChart.Data<>(yearFormat.format(year), regression.predict(year)));
        }

        var chart = new LineChart<>(xAxis, yAxis);
        chart.getData().add(series);
        chart.getData().add(predictionSeries);

        var scene = new Scene(chart, 800, 600);

        series.setName("Mexico population");
        predictionSeries.setName("Mexico Population forecast");
        xAxis.setLabel("Years");
        yAxis.setLabel("Population");
        primaryStage.setTitle("Mexico population linear regression");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
