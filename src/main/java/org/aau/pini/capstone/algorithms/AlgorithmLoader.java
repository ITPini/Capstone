package org.aau.pini.capstone.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
public final class AlgorithmLoader {
    private final List<ImageAlgorithm> imageAlgorithms = new ArrayList<>();

    /**
     * Loads all algorithms into a list.
     * Insert new algorithms here.
     */
    public AlgorithmLoader() {
        imageAlgorithms.add(new Invert());
        imageAlgorithms.add(new Greyscale());
        imageAlgorithms.add(new Contrast());
        imageAlgorithms.add(new Brightness());
        imageAlgorithms.add(new Vibrancy());
        imageAlgorithms.add(new GreyscaleAveraging());
        imageAlgorithms.add(new RemoveRed());
        imageAlgorithms.add(new RemoveRedGreen());
        imageAlgorithms.add(new Shadow());
        imageAlgorithms.add(new Colorizer());
    }

    public List<ImageAlgorithm> getAlgorithms() {
        return imageAlgorithms;
    }
}
