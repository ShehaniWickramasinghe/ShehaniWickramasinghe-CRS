package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StudentController {
    
    @FXML
    private Label lblDateOfBirth;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblProgramOfStudy;

    @FXML
    private Label lblStudentId;

    @FXML
    private Label lblStudentName;

    @FXML
    private DatePicker txtDOB;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPhoneNo;

    @FXML
    private ComboBox<?> txtProgramOfStudy;

    @FXML
    private TextField txtStudentId;

    @FXML
    private TextField txtStudentName;

    @FXML
    private TextField txtStudentName1;

    @FXML
    void btnGoBackOnAction(ActionEvent event) throws IOException {
            System.out.println("Go Back");
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/login.fxml"))));
        stage.show();
    }

    @FXML
    void btnSubmitOnAction(ActionEvent event) {
            System.out.println("Submit student details");
    }
}
