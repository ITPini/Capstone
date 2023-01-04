package org.aau.pini.capstone.algorithms;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmLoader {
    private List<ImageAlgorithm> imageAlgorithms = new ArrayList<>();

    public AlgorithmLoader() {
        imageAlgorithms.add(new Invert());
        imageAlgorithms.add(new Greyscale());
        imageAlgorithms.add(new Contrast());
        imageAlgorithms.add(new Exposure());
        imageAlgorithms.add(new ExposureV2());
        imageAlgorithms.add(new Vibrance());
    }

    public List<ImageAlgorithm> getAlgorithms() {
        return imageAlgorithms;
    }
}
