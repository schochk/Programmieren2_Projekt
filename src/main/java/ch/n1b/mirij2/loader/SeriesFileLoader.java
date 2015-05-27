package ch.n1b.mirij2.loader;

import ch.n1b.mirij2.model.SeriesFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Mirjam on 13.05.2015.
 */
public interface SeriesFileLoader {
    SeriesFile load(File file) throws FileNotFoundException, IOException;
}
