import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class BarChartDisplay extends JFrame {

    List<String> listOfGenre = Arrays.asList("Sports", "Science Fiction", "Mystery");

    /**
     *
     * @param appTitle Title of app
     * @param list Data represented as ViewerModel Object
     * @param listOfCities List of Cities for which to display data
     */
    public BarChartDisplay(String appTitle,List<ViewerModel> list,List<String> listOfCities,List<String> aggregationType) {
        super(appTitle);

        // Create Dataset
        CategoryDataset dataset = createDataset(list, listOfCities, aggregationType);

        //Create chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Total Number Of Viewers From Pittsburgh or Cleveland by Genre", //Chart Title
                "Genre", // Category axis
                "Total Number Of Viewers", // Value axis
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        chart.setBackgroundPaint(Color.LIGHT_GRAY);
        if (aggregationType.contains("Average")) {
            chart = ChartFactory.createBarChart(
                    "Average Number Of Viewers From Pittsburgh or Cleveland by Genre", //Chart Title
                    "City", // Category axis
                    "Average Number Of Viewers", // Value axis
                    dataset,
                    PlotOrientation.VERTICAL,
                    true, true, false
            );
        }

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    /**
     *
     * @param list Data represented as ViewerModel Object
     * @param listOfCities List of Cities for which to display data
     * @return Total Number of Viewers Based On listOfCities
     */
    private CategoryDataset createDataset(List<ViewerModel> list, List<String> listOfCities, List<String> aggregationType) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int sum = 0;
        if (aggregationType.contains("Total")) {
            System.out.println("total Pass:");
    
            for (String genre : listOfGenre) {
                ViewerModel m = null;
                for (int i = 0; i < list.size(); i++) {
                    m = list.get(i);
                    if (list.get(i).programGenre.equals(genre) && listOfCities.contains(m.viewHomeTown)) {
                        sum += Integer.parseInt(m.numberOfViewers);
                    }
                }
                System.out.println(sum + " - " + genre);
                dataset.addValue(sum, "s",genre);
                sum = 0;
            }
        } else if (aggregationType.contains("Average")) {
            dataset = getAverageNumberOfViewers(list, listOfCities);
        }
        return dataset;
    }

    /**
     *
     * @param list Data represented as ViewerModel Object
     * @param listOfCities List of Cities for which to display data
     * @return returns "average number of viewers" grouped by city
     */
    private DefaultCategoryDataset getAverageNumberOfViewers(List<ViewerModel> list, List<String> listOfCities) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int totalSum;
        int totalCount;
        int average;

        // loop over each city add total number of viewers per city to get average
        for (String city: listOfCities) {
            totalSum = 0;
            totalCount = 0;
            System.out.println("City: " + city);
            ViewerModel m = null;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).viewHomeTown.equals(city)) {
                    m = list.get(i);
                    totalSum += Integer.parseInt(m.numberOfViewers);
                    totalCount++;
                }
            }
            if (totalCount != 0) {
                average = (totalSum / totalCount);
                System.out.println("average:- " + average + " totalSum:- " + totalSum + " totalCount:- " + totalCount);
                dataset.addValue(average, m.viewHomeTown, m.viewHomeTown);
            }
        }
        return dataset;
    }
}
