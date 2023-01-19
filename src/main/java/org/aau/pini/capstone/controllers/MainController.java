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
import org.aau.pini.capstone.io.MultiThreadRender;
import org.aau.pini.capstone.io.BufferedImageRender;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
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
    @FXML
    private Label timeLabel;

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
            setImage(fileIO.importImage(file));
            imageView.setImage(image);
            setMetaDataLabelText((int) image.getWidth(), (int) image.getHeight());
            setBufferedImage(SwingFXUtils.fromFXImage(image, null));
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
        if (image == null || getSelectedAlgorithm() == null) {
            return;
        }
        // Apply the selected algorithm
        ImageAlgorithm imageAlgorithm = getSelectedAlgorithm();
        imageAlgorithm.setFactor((float) slider.getValue());

        // Render the image
        long startTime = System.currentTimeMillis();

        BufferedImageRender bufferedImageRender = new MultiThreadRender(imageAlgorithm, getBufferedImage(), 6);
        setBufferedImage(bufferedImageRender.getBufferedImage());

        long endTime = System.currentTimeMillis();
        timeLabel.setText("Execution time: " + (endTime - startTime) + " ms");

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

    private BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    private void setImage(Image image) {
        this.image = image;
    }

    private void setMetaDataLabelText(int width, int height) {
        dimensionsLabel.setText("Dimensions: " + width + " x " + height);
        widthLabel.setText("Width: " + width);
        heightLabel.setText("Height: " + height);
        sizeLabel.setText("Size: " + width*height + " px");
    }
}