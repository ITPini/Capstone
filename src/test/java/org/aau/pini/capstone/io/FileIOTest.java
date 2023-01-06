/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.io;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileIOTest {

    @Test
    void testImportFixedImage() {
        File validPngFile = new File("src/test/resources/images/4.2.07.png");
        try {
            assertTrue(validPngFile.exists());

            Image image = FileIO.importImage(validPngFile);
            assertNotNull(image);
            assertEquals(512, image.getWidth());
            assertEquals(512, image.getHeight());
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void testImportOfNonExistentFile() {
        File validPngFile = new File("src/this/image/doesnt/exist.png");
        try {
            assertFalse(validPngFile.exists());
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void exportFixedImage() {
        FileIO fileIO = new FileIO();
        File validPngFile = new File("src/test/resources/images/4.1.07.png");
        File exportFile = new File("src/test/resources/images/4.1.07-exported.png");

        try {
            Image image = fileIO.importImage(validPngFile);
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
            fileIO.exportImage(bufferedImage, exportFile);
        } catch (Exception e) {
            fail(e);
        }

        try {
            Image image = fileIO.importImage(exportFile);
            assertTrue(exportFile.exists());
            assertNotNull(image);
            assertEquals(256, image.getWidth());
            assertEquals(256, image.getHeight());
        } catch (Exception e) {
            fail(e);
        }
    }
}