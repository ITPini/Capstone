package org.aau.pini.capstone.io;

import org.aau.pini.capstone.algorithms.ImageAlgorithm;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
public final class MultiThreadRender extends Thread implements BufferedImageRender {
    private final ImageAlgorithm imageAlgorithm;
    private final BufferedImage bufferedImage;
    private final int threadCount;

    public MultiThreadRender(ImageAlgorithm imageAlgorithm, BufferedImage bufferedImage, int threadCount) {
        this.imageAlgorithm = imageAlgorithm;
        this.bufferedImage = bufferedImage;
        this.threadCount = threadCount;
    }

    @Override
    public BufferedImage getBufferedImage() {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        int rowsPerThread = height / threadCount;

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            int startRow = i * rowsPerThread;
            int endRow = startRow + rowsPerThread;
            if (i == threadCount - 1) {
                endRow = height;
            }

            Thread thread = new Thread(new ImageProcessor(startRow, endRow, width, imageAlgorithm, bufferedImage));
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return bufferedImage;
    }

    private final class ImageProcessor implements Runnable {
        private final int startRow;
        private final int endRow;
        private final int width;
        private final ImageAlgorithm imageAlgorithm;
        private final BufferedImage bufferedImage;

        private ImageProcessor(int startRow, int endRow, int width, ImageAlgorithm imageAlgorithm, BufferedImage bufferedImage) {
            this.startRow = startRow;
            this.endRow = endRow;
            this.width = width;
            this.imageAlgorithm = imageAlgorithm;
            this.bufferedImage = bufferedImage;
        }

        @Override
        public void run() {
            for (int x = 0; x < width; x++) {
                for (int y = startRow; y < endRow; y++) {
                    Color color = new Color(bufferedImage.getRGB(x, y));

                    bufferedImage.setRGB(x, y, new Color(
                            imageAlgorithm.calculateRed(color),
                            imageAlgorithm.calculateGreen(color),
                            imageAlgorithm.calculateBlue(color)
                    ).getRGB());
                }
            }
        }
    }
}
