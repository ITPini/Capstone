package org.aau.pini.capstone.io;

import org.aau.pini.capstone.algorithms.ImageAlgorithm;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * CURRENTLY NOT IN USE
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
public final class SingleThreadRender implements BufferedImageRender {
    private final ImageAlgorithm imageAlgorithm;
    private final BufferedImage bufferedImage;

    public SingleThreadRender(ImageAlgorithm imageAlgorithm, BufferedImage bufferedImage) {
        this.imageAlgorithm = imageAlgorithm;
        this.bufferedImage = bufferedImage;
    }

    @Override
    public BufferedImage getBufferedImage() {
        for (int x = 0; x < bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                Color color = new Color(bufferedImage.getRGB(x, y));

                bufferedImage.setRGB(x, y, new Color(
                        imageAlgorithm.calculateRed(color),
                        imageAlgorithm.calculateGreen(color),
                        imageAlgorithm.calculateBlue(color)
                ).getRGB());
            }
        }
        return bufferedImage;
    }
}
