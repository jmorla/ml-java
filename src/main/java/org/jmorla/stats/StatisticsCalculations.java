package org.jmorla.stats;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.Arrays;

public class StatisticsCalculations {

    public static void main(String[] args) {
        double[] testData = {12.5, 18.3, 11.2, 19.0, 22.1, 14.3, 16.2, 12.5,
                17.8, 16.5, 11.2};

        DescriptiveStatistics statistics = new DescriptiveStatistics();
        for(var data: testData) {
            statistics.addValue(data);
        }

        System.out.println("Mean: " + statistics.getMean());
        System.out.println("Median: " + statistics.getPercentile(50));
        System.out.println("Mode: " + Arrays.toString(StatUtils.mode(testData)));
        System.out.println("Standard deviation: " + statistics.getStandardDeviation());
    }
}
