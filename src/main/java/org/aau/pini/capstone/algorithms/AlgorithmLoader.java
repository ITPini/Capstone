/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import java.util.ArrayList;
import java.util.List;

public final class AlgorithmLoader {
    private List<ImageAlgorithm> imageAlgorithms = new ArrayList<>();

    /**
     * Loads all algorithms into a list.
     * Insert new algorithms here.
     */
    public AlgorithmLoader() {
        imageAlgorithms.add(new Invert());
        imageAlgorithms.add(new Greyscale());
        imageAlgorithms.add(new Contrast());
        imageAlgorithms.add(new Exposure());
        imageAlgorithms.add(new Vibrancy());
        imageAlgorithms.add(new GreyscaleAveraging());
        imageAlgorithms.add(new RemoveRed());
        imageAlgorithms.add(new RemoveRedGreen());
    }

    public List<ImageAlgorithm> getAlgorithms() {
        return imageAlgorithms;
    }
}
