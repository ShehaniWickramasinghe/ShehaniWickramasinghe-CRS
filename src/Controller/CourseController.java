package controller;



import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CourseController {

    @FXML
    private Button btnGoBack;

    @FXML
    private Button btnSave;

    @FXML
    private Label lblClick;

    @FXML
    private Label lblCourseDetails;

    @FXML
    private Label lblCourseId;

    @FXML
    private Label lblCourseId1;

    @FXML
    private Label lblCreditHour;

    @FXML
    private Label lblDepartment;

    @FXML
    private Label lblMEC;

    @FXML
    private Label lblPrerequisities;

    @FXML
    private TextField txtCourseDetails;

    @FXML
    private TextField txtCourseDetails1;

    @FXML
    private ComboBox<?> txtDepartment;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtId1;

    @FXML
    private TextField txtMEC;

    @FXML
    private TextField txtPrerequisities;

    @FXML
    private TextField txtPrerequisities1;

    @FXML
    private TextField txtPrerequisities11;

    @FXML
    void btnGoBackOnAction(ActionEvent event) throws IOException {
        System.out.println("Go Back");
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/category.fxml"))));
        stage.show();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }
}
