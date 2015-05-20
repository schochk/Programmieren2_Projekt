package ch.n1b.mirij2.loader;

import ch.n1b.mirij2.model.Serie;
import ch.n1b.mirij2.model.SeriesFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Mirjam on 13.05.2015.
 */
public class RowFile implements SeriesFileLoader {
    @Override
    public SeriesFile load(String fileName) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(new File(fileName));
        int size = Integer.parseInt(scanner.nextLine());
        List<String> names = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            names.add(scanner.nextLine());
        }

        String seperator = scanner.nextLine();
        SeriesFile seriesFile = new SeriesFile();
        for (int i = 0; i < size; i++) {
            List<Double> rowValues = parseRowStream(scanner.nextLine(), seperator);
            Serie serie= new Serie(names.get(i), rowValues);
            seriesFile.add(serie);
        }


        return seriesFile;
    }
    @Deprecated
    private List<Double> parseRow(String row, String seperator) {
        String[] values = row.split(seperator);
        List<Double> valuesList = new LinkedList<>();
        for (String value : values) {
            valuesList.add(Double.parseDouble(value));
        }
        return valuesList;
    }
    private List<Double> parseRowStream(String row, String seperator) {
        String[] values = row.split(seperator);
        return Arrays.asList(values).parallelStream().map(s -> Double.parseDouble(s)).collect(Collectors.toList());
    }

}


