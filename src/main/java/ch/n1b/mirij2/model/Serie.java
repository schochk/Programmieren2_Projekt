package ch.n1b.mirij2.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mirjam on 17.05.2015.
 */
public class Serie {
    private List<Double> points = new ArrayList<>();
    private final String name;

    public Serie(String name, List<Double> points) {
        this.name = name;
        this.points = points;
    }

    public Serie(String name) {
        this.name = name;
    }

    public double get(int index) {
        return points.get(index);

    }

    public int size() {
        return points.size();
    }

    public String getName() {
        return name;
    }

    public void add(double point) {
        points.add(point);
    }

    public Vector2f range(){
        double min = points.stream().mapToDouble(o -> o.doubleValue()).min().getAsDouble();
        double max = points.stream().mapToDouble(o -> o.doubleValue()).max().getAsDouble();
        return new Vector2f(min, max);
    }

}
