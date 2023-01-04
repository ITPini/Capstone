package org.aau.pini.capstone.algorithms;

public abstract class ImageAlgorithm implements ColorAlgorithm {
    protected float factor;
    public String name;

    public ImageAlgorithm() {
    }

    protected int checkColorValueRange(float colorValue) {
        if (colorValue > 255) {
            return 255;
        } else if (colorValue < 0) {
            return 0;
        } else {
            return (int) colorValue;
        }
    }

    public void setFactor(float factor) {
        this.factor = factor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
