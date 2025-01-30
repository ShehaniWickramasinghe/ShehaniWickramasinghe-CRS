package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private Button btnDelete;

    @FXML
    private Button btnGoBack;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    void btnGoBackOnAction(ActionEvent event) throws IOException {
            System.out.println("Go Back");
        Stage stage=(Stage)btnGoBack.getScene().getWindow();
        FXMLLoader loader= new FXMLLoader(getClass().getResource("../view/login.fxml"));
        Parent root=loader.load();

        Stage stage2=new Stage();
        stage2.setScene(new Scene(root));
        stage2.show();
        stage.close();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        System.out.println("delete details");
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
            System.out.println("save details");
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        System.out.println("update details");
    }
}
