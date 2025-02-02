package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class reportController {
    @FXML
    private Button btnProfile;

    @FXML
    private Button btnVacancies;

    @FXML
    private TableColumn<Reportdto,String> colCourse;

    @FXML
    private TableColumn<Reportdto,String> colDepartment;

    @FXML
    private TableColumn<Reportdto,String> colGrade;

    @FXML
    private TableColumn<Reportdto,String> colStudentId;

    @FXML
    private TableColumn<Reportdto,String> colStudentName;

    @FXML
    private Label lblDescription;

    @FXML
    private TableView<Reportdto> tblRecord;

    @FXML
    private TextField txtCheck;

    @FXML
    private Button txtSearch;

    @FXML
    void btnProfileOnAction(ActionEvent event) {

    }

    @FXML
    void btnVacanciesOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }
}
