package org.aau.pini.capstone.io;

import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;

public class FileIO {
    public static Image ImportImage(){
        // TODO: Use enum for ExtensionFilters

        try{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Import image");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
            );
            File file = fileChooser.showOpenDialog(null);

            if (file != null){
                return new Image(new FileInputStream(file));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void displayToImageView(ImageView imageView, Image image){
        imageView.setImage(image);
    }

    public static void exportImage(BufferedImage bufferedImage){
        // TODO: Use enum for ExtensionFilters

        try{
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("PNG Files (*.png)", "*.png")
            );
            File file = fileChooser.showSaveDialog(null);

            if (file != null){
                ImageIO.write(bufferedImage, "png", file);
            } else {
                System.out.println("No file");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
