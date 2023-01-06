/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.controllers;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.aau.pini.capstone.algorithms.AlgorithmLoader;
import org.aau.pini.capstone.algorithms.ImageAlgorithm;
import org.aau.pini.capstone.io.FileIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private BufferedImage bufferedImage;
    private Image image;
    private ImageAlgorithm selectedAlgorithm;
    @FXML
    private ImageView imageView;
    @FXML
    private ListView<ImageAlgorithm> algorithmListView;
    @FXML
    private Slider slider;
    @FXML
    private Label dimensionsLabel;
    @FXML
    private Label widthLabel;
    @FXML
    private Label heightLabel;
    @FXML
    private Label sizeLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AlgorithmLoader algorithmLoader = new AlgorithmLoader();

        algorithmListView.getItems().addAll(algorithmLoader.getAlgorithms());
    }

    @FXML
    private void onListViewSelectedChange(MouseEvent event) {
        setSelectedAlgorithm(algorithmListView.getSelectionModel().getSelectedItem());

        slider.setMin(selectedAlgorithm.getMinimumFactor());
        slider.setMax(selectedAlgorithm.getMaximumFactor());
    }

    @FXML
    private void onImportClick(ActionEvent event){
        FileIO fileIO = new FileIO();
        File file = fileIO.openImportImageDialog();

        if (file == null){
            return;
        }

        try {
            setImage(FileIO.importImage(file));
            imageView.setImage(image);
            setMetaDataLabelText((int) image.getWidth(), (int) image.getHeight());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void onExportClick(ActionEvent event) {
        if (image == null) {
            return;
        }

        FileIO fileIO = new FileIO();
        File file = fileIO.openExportImageDialog();

        try {
            fileIO.exportImage(bufferedImage, file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void onApplyClick(ActionEvent event){
        if (image == null){
            return;
        } else if (getSelectedAlgorithm() == null) {
            return;
        }
        setBufferedImage(SwingFXUtils.fromFXImage(image, null));

        // Apply the selected algorithm
        ImageAlgorithm imageAlgorithm = getSelectedAlgorithm();
        imageAlgorithm.setFactor((float) slider.getValue());

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

        // Update the image view
        setImage(SwingFXUtils.toFXImage(bufferedImage, null));
        imageView.setImage(image);
    }

    private ImageAlgorithm getSelectedAlgorithm() {
        return selectedAlgorithm;
    }

    private void setSelectedAlgorithm(ImageAlgorithm selectedAlgorithm) {
        this.selectedAlgorithm = selectedAlgorithm;
    }

    private void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    private void setImage(Image image) {
        this.image = image;
    }

    private void setMetaDataLabelText(int width, int height) {
        dimensionsLabel.setText("Dimensions: " + width + "x" + height);
        widthLabel.setText("Width: " + width);
        heightLabel.setText("Height: " + height);
        sizeLabel.setText("Size: " + width*height + " px");
    }
}