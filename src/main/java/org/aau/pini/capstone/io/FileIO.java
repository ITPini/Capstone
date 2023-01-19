package org.aau.pini.capstone.io;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
public final class FileIO {

    /**
     * Imports an image from the file system.
     * @return - The imported image. Null if no file was selected.
     * @throws FileNotFoundException - If the file does not exist.
     */
    // TODO: This should be not be static method
    public Image importImage(File file) throws FileNotFoundException {

        if (file != null){
            return new Image(new FileInputStream(file));
        }

        return null;
    }

    /**
     * Opens a file chooser dialog for importing an image.
     * @return - The file that was selected. Null if no file was selected.
     */
    public File openImportImageDialog() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Import image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.jpg", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            return new File(file.toURI());
        }
        return null;
    }

    /**
     * Exports an image to the file system.
     * @param bufferedImage - The image to be exported.
     * @param file - The file (path) to export to.
     * @throws IOException - If the file cannot be written to.
     */
    public void exportImage(BufferedImage bufferedImage, File file) throws IOException {
        // TODO: 2-1-2023  Add support for other image formats

        if (file != null) {
            ImageIO.write(bufferedImage, "png", file);
        }
    }

    /**
     * Opens a file chooser dialog for exporting an image.
     * @return - The file (path) that was selected. Null if no file (path) was selected.
     */
    public File openExportImageDialog(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export image");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            return new File(file.toURI());
        }
        return null;
    }
}
