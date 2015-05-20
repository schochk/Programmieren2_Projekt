package mirij2.loader;

import mirij2.model.SeriesFile;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Mirjam on 13.05.2015.
 */
public interface SeriesFileLoader {
    SeriesFile load(String fileName) throws FileNotFoundException, IOException;
}
