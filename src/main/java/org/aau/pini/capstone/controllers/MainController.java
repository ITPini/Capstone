package org.aau.pini.capstone.controllers;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import org.aau.pini.capstone.algorithms.ImageAlgorithm;
import org.aau.pini.capstone.algorithms.AlgorithmLoader;
import org.aau.pini.capstone.io.FileIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private BufferedImage bufferedImage;
    private Image image;
    private Color hoverColor;
    @FXML
    private ImageView imageView;
    @FXML
    private ListView<ImageAlgorithm> algorithmListView;
    @FXML
    private Slider slider;
    @FXML
    private Rectangle colorBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AlgorithmLoader algorithmLoader = new AlgorithmLoader();

        algorithmListView.getItems().addAll(algorithmLoader.getAlgorithms());
    }

    @FXML
    void displayColor(MouseEvent event) {
        hoverColor = new Color(bufferedImage.getRGB((int) event.getX(), (int) event.getY()));
        javafx.scene.paint.Color paint = new javafx.scene.paint.Color(hoverColor.getRed(), hoverColor.getGreen(), hoverColor.getBlue(), 0);
        colorBox.setFill(paint);
    }


    @FXML
    void actionImport(ActionEvent event){
        try {
            setImage(FileIO.ImportImage());
            if (image == null) {
                System.out.println("No new images");
                return;
            }

            imageView.setImage(image);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void actionExport(ActionEvent event){
        FileIO.exportImage(bufferedImage);
    }

    @FXML
    void applyAlgorithm(ActionEvent event){
        if (image == null){
            System.out.println("No image");
            return;
        } else if (getSelectedAlgorithm() == null) {
            System.out.println("No algorithm selected");
            return;
        }

        setBufferedImage(SwingFXUtils.fromFXImage(image, null));
        setBufferedImage(apply((float) getSlider().getValue()));

        setImage(SwingFXUtils.toFXImage(bufferedImage, null));
        imageView.setImage(image);
    }

    private BufferedImage apply(float value) {
        ImageAlgorithm imageAlgorithm = getSelectedAlgorithm();
        imageAlgorithm.setFactor(value);

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

    private ImageAlgorithm getSelectedAlgorithm() {
        return algorithmListView.getSelectionModel().getSelectedItem();
    }

    public Slider getSlider() {
        return slider;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
