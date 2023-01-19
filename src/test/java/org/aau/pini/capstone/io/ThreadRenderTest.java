package org.aau.pini.capstone.io;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.aau.pini.capstone.algorithms.AlgorithmLoader;
import org.aau.pini.capstone.algorithms.ImageAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
class ThreadRenderTest {

    private final ImageAlgorithm imageAlgorithm = new AlgorithmLoader().getAlgorithms().get(1);
    private File validPngFile;
    private BufferedImage bufferedImage;
    private Image image;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        validPngFile = new File("src/test/resources/images/4.2.07.png");
        image = new FileIO().importImage(validPngFile);
        bufferedImage = SwingFXUtils.fromFXImage(image, null);
    }

    @Disabled
    void testSingleThreadRender() {
        BufferedImageRender bufferedImageRender = new SingleThreadRender(imageAlgorithm, bufferedImage);
        long startTime = System.currentTimeMillis();
        bufferedImageRender.getBufferedImage();
        long endTime = System.currentTimeMillis();
        System.out.println("Single Thread Render: " + (endTime - startTime) + "ms");
    }

    @Test
    void testOneThreads() {
        BufferedImageRender bufferedImageRender = new MultiThreadRender(imageAlgorithm, bufferedImage, 1);
        long startTime = System.currentTimeMillis();
        bufferedImageRender.getBufferedImage();
        long endTime = System.currentTimeMillis();
        System.out.println("1 thread: " + (endTime - startTime) + " ms");
    }

    @Test
    void testTwoThreads() {
        BufferedImageRender bufferedImageRender = new MultiThreadRender(imageAlgorithm, bufferedImage, 2);
        long startTime = System.currentTimeMillis();
        bufferedImageRender.getBufferedImage();
        long endTime = System.currentTimeMillis();
        System.out.println("2 threads: " + (endTime - startTime) + " ms");
    }

    @Test
    void testFourThreads() {
        BufferedImageRender bufferedImageRender = new MultiThreadRender(imageAlgorithm, bufferedImage, 4);
        long startTime = System.currentTimeMillis();
        bufferedImageRender.getBufferedImage();
        long endTime = System.currentTimeMillis();
        System.out.println("4 threads: " + (endTime - startTime) + " ms");
    }

    @Test
    void testSixThreads() {
        BufferedImageRender bufferedImageRender = new MultiThreadRender(imageAlgorithm, bufferedImage, 6);
        long startTime = System.currentTimeMillis();
        bufferedImageRender.getBufferedImage();
        long endTime = System.currentTimeMillis();
        System.out.println("6 threads: " + (endTime - startTime) + " ms");
    }

    @Test
    void testEightThreads() {
        BufferedImageRender bufferedImageRender = new MultiThreadRender(imageAlgorithm, bufferedImage, 8);
        long startTime = System.currentTimeMillis();
        bufferedImageRender.getBufferedImage();
        long endTime = System.currentTimeMillis();
        System.out.println("8 threads: " + (endTime - startTime) + " ms");
    }

    @Disabled
    void testSixteenThreads() {
        BufferedImageRender bufferedImageRender = new MultiThreadRender(imageAlgorithm, bufferedImage, 16);
        long startTime = System.currentTimeMillis();
        bufferedImageRender.getBufferedImage();
        long endTime = System.currentTimeMillis();
        System.out.println("16 threads: " + (endTime - startTime) + " ms");
    }

    @Disabled
    void testThirtyTwoThreads() {
        BufferedImageRender bufferedImageRender = new MultiThreadRender(imageAlgorithm, bufferedImage, 32);
        long startTime = System.currentTimeMillis();
        bufferedImageRender.getBufferedImage();
        long endTime = System.currentTimeMillis();
        System.out.println("32 threads: " + (endTime - startTime) + " ms");
    }

    @Disabled
    void testSixtyFourThreads() {
        BufferedImageRender bufferedImageRender = new MultiThreadRender(imageAlgorithm, bufferedImage, 64);
        long startTime = System.currentTimeMillis();
        bufferedImageRender.getBufferedImage();
        long endTime = System.currentTimeMillis();
        System.out.println("64 threads: " + (endTime - startTime) + " ms");
    }

    @Disabled
    void testOneHundredTwentyEightThreads() {
        BufferedImageRender bufferedImageRender = new MultiThreadRender(imageAlgorithm, bufferedImage, 128);
        long startTime = System.currentTimeMillis();
        bufferedImageRender.getBufferedImage();
        long endTime = System.currentTimeMillis();
        System.out.println("128 threads: " + (endTime - startTime) + " ms");
    }

    @Disabled
    void testTwoHundredFiftySixThreads() {
        BufferedImageRender bufferedImageRender = new MultiThreadRender(imageAlgorithm, bufferedImage, 256);
        long startTime = System.currentTimeMillis();
        bufferedImageRender.getBufferedImage();
        long endTime = System.currentTimeMillis();
        System.out.println("256 threads: " + (endTime - startTime) + " ms");
    }

    @Disabled
    void testFiveHundredTwelveThreads() {
        BufferedImageRender bufferedImageRender = new MultiThreadRender(imageAlgorithm, bufferedImage, 512);
        long startTime = System.currentTimeMillis();
        bufferedImageRender.getBufferedImage();
        long endTime = System.currentTimeMillis();
        System.out.println("512 threads: " + (endTime - startTime) + " ms");
    }

    @Disabled
    void testOneThousandTwentyFourThreads() {
        BufferedImageRender bufferedImageRender = new MultiThreadRender(imageAlgorithm, bufferedImage, 1024);
        long startTime = System.currentTimeMillis();
        bufferedImageRender.getBufferedImage();
        long endTime = System.currentTimeMillis();
        System.out.println("1024 threads: " + (endTime - startTime) + " ms");
    }
}