module com.atmbanksimulator {
    requires javafx.controls;
    requires javafx.fxml;
    //requires com.atmbanksimulator;


    opens com.atmbanksimulator to javafx.fxml;
    exports com.atmbanksimulator;
}