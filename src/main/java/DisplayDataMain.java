import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Rehan Anwar
 * This is main execution class
 */
public class DisplayDataMain extends JPanel{

    public static void main(String[] args) {

        // Read csv file and returns data as a list of objects
        CsvFileReader csvFileReader = new CsvFileReader();
        String fileName = "SoftwareEngineeringProgrammingExercise.csv";
        List<ViewerModel> movieViewersList = null;
        try {
            movieViewersList = csvFileReader.fileReader(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display bar chart
        // List of cities for which to Display Data.
        List<String> listOfCities = Arrays.asList("Pittsburgh", "Cleveland");
        List<String> aggregationTypeList = Arrays.asList("Total");
        // if aggregation type is Average uncomment below line
//         List<String> aggregationTypeList = Arrays.asList("Average");
        BarChartDisplay chart = new BarChartDisplay("Display Total Number Of Viewers", movieViewersList, listOfCities, aggregationTypeList);
        chart.pack();
        chart.setVisible(true);
    }
}
