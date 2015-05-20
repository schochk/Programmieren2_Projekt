package ch.n1b.mirij2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mirjam on 17.05.2015.
 */
public class SeriesFile {
    private List<Serie> seriesList = new ArrayList<>();

    public Serie getSerie(String name) {
        return seriesList.stream().filter(serie -> serie.getName().equals(name)).findFirst().get();
    }

    public List<String> getNames() {
        return seriesList.parallelStream().map(Serie::getName).collect(Collectors.toList());
    }

    public void add(Serie serie) {
        seriesList.add(serie);
    }

}
