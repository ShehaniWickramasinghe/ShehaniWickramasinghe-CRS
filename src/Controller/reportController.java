package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class reportController {
    @FXML
    private Button btnProfile;

    @FXML
    private Button btnVacancies;

    // @FXML
    // private TableColumn<Reportdto,String> colCourse;

    // @FXML
    // private TableColumn<Reportdto,String> colDepartment;

    // @FXML
    // private TableColumn<Reportdto,String> colGrade;

    // @FXML
    // private TableColumn<Reportdto,String> colStudentId;

    // @FXML
    // private TableColumn<Reportdto,String> colStudentName;

    // @FXML
    // private Label lblDescription;

    // @FXML
    // private TableView<Reportdto> tblRecord;

    @FXML
    private TextField txtCheck;

    @FXML
    private Button btnSearch;

    @FXML
    void btnProfileOnAction(ActionEvent event) throws IOException {
            Stage stage=(Stage)btnProfile.getScene().getWindow();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/student.fxml"));
            Parent root=loader.load();
            
            Stage stage1=new Stage();
            stage1.setScene(new Scene(root));
            stage1.setTitle("Student Registration Form");
            stage1.show();
            stage.close();
    }

    @FXML
    void btnVacanciesOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }
}
