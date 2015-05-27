package ch.n1b.mirij2.loader;

import ch.n1b.mirij2.model.Serie;
import ch.n1b.mirij2.model.SeriesFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * Created by Mirjam on 06.05.2015.
 */
public class ColumnFile implements SeriesFileLoader {
    @Override
    public SeriesFile load(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);

        List<String> names = parseNames(scanner.nextLine());
        List<Serie> series = new ArrayList<>();


        for (String name : names) {
            Serie serie = new Serie(name);
            series.add(serie);
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<Double> rowValues = parseRowStream(line);

            for (int i = 0; i < rowValues.size(); i++) {
                series.get(i).add(rowValues.get(i));
            }

        }

        SeriesFile dataFile = new SeriesFile();
        for (Serie serie : series) {
            dataFile.add(serie);
        }
        return dataFile;
    }
    private List<String> parseNames(String row) {
        String[] values = row.split("\t");
        return Arrays.asList(values);
    }
    private List<Double> parseRowStream(String row) {
        String[] values = row.split("\t");
        return Arrays.asList(values).parallelStream().map(s -> Double.parseDouble(s)).collect(Collectors.toList());
    }


}

