import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * Reads A CSV file and return a list.
 */
public class CsvFileReader {

    /**
     *
     * @param fileName : Name of File To Read.
     * @return List of Objects "ViewerModel"
     * @throws IOException throws IOException when file is not found
     */
    public List<ViewerModel> fileReader(String fileName) throws IOException {
        URL url = getClass().getResource(fileName);
        File file = new File(url.getPath());
        List<ViewerModel> list = new ArrayList<>();
        MappingIterator<ViewerModel> personIter = new CsvMapper().readerWithTypedSchemaFor(ViewerModel.class).readValues(file);
        while(personIter.hasNext()) {
            ViewerModel m = personIter.next();
            list.add(m);
        }
        return list;
    }
}
