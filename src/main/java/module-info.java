module org.aau.pini.capstone {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires javafx.swing;

    opens org.aau.pini.capstone.controllers to javafx.fxml;
    exports org.aau.pini.capstone;
}