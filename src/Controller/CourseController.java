package controller;



import dto.Coursedto;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CourseController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnGoBack;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<Coursedto, String> colCourseId;

    @FXML
    private TableColumn<Coursedto, String> colCourseName;

    @FXML
    private TableColumn<Coursedto, String> colCreditHours;

    @FXML
    private TableColumn<Coursedto,String> colDepartment;

    @FXML
    private TableColumn<Coursedto, Integer> colMEC;

    @FXML
    private TableColumn<Coursedto, String> colprerequisites;

    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private Label lblCourseId;

    @FXML
    private Label lblCourseName;

    @FXML
    private Label lblCreditHours;

    @FXML
    private Label lblDepartment;

    @FXML
    private Label lblMEC;

    @FXML
    private Label lblprerequisites;

    @FXML
    private TableView<Coursedto> tblCourse;

    @FXML
    private TextField txtCourseId;

    @FXML
    private TextField txtCourseName;

    @FXML
    private TextField txtCreditHours;

    @FXML
    private TextField txtMEC;

    @FXML
    private TextField txtprerequisites;

    @FXML
    private TextField txtprerequisites1;
    
    void initialize(){
        colCourseId.setCellValueFactory(new PropertyValueFactory<>("Course Id"));
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("Course Name"));
        colCreditHours.setCellValueFactory(new PropertyValueFactory<>("Credit Hours"));
        colprerequisites.setCellValueFactory(new PropertyValueFactory<>("prerequisites"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("Department"));
        colMEC.setCellValueFactory(new PropertyValueFactory<>("MEC"));
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnGoBackOnAction(ActionEvent event) throws IOException {
        System.out.println("Go Back");
            Stage stage=(Stage)btnGoBack.getScene().getWindow();
            FXMLLoader load= new FXMLLoader(getClass().getResource("../view/login.fxml"));
            Parent root=load.load();
    
            Stage stage1=new Stage();
            stage1.setScene(new Scene(root));
            stage1.show();
            stage.close();

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }


}
