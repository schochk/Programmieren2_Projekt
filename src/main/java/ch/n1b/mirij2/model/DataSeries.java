package ch.n1b.mirij2.model;


/**
 * Created by Mirjam on 17.05.2015.
 * GoF decorator pattern
 */
public class DataSeries {


    public final Serie serieX,serieY;

    public DataSeries(Serie serieX, Serie serieY) {
        if (serieX.size() != serieY.size()) {
            System.out.println("WARN: Series size does not match!");
        }
        this.serieX = serieX;
        this.serieY = serieY;
    }

    public Vector2f get(int index) {
        return new Vector2f(serieX.get(index), serieY.get(index));
    }

    public int size() {
        return Math.min(serieX.size(), serieY.size());
    }

    public Vector2f rangeX(){
        return serieX.range();
    }

    public Vector2f rangeY(){
        return serieY.range();
    }


}
