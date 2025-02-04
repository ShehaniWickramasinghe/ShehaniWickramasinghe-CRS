package controller;

import java.io.IOException;

import dto.Reportdto;
import java.util.Properties;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.custom.ReportService;
import service.custom.impl.ReportServiceImpl;

public class reportController {
    @FXML
    private Button btnProfile;

    @FXML
    private Button btnVacancies;

    @FXML
    private Button btnSchedule;

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
    private TableView<Reportdto> tblRecord;

    @FXML
    private TextField txtCheck;

    @FXML
    private Button btnSearch;

    @FXML
    void btnProfileOnAction(ActionEvent event) throws IOException {
        System.out.println("/////////////////////");
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
            System.out.println("vacancies");
    }

    
    private void alert(Alert.AlertType alertType, String header,String context){
        Alert alert=new Alert(alertType);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.showAndWait();
    }
    @FXML
    void btnSearchOnAction(ActionEvent event) throws Exception {
           
        String id = txtCheck.getText().trim();
        if (id.isEmpty()) {
            alert(Alert.AlertType.WARNING, "Input Error", "Please enter a student ID");
            return;
        }

            ReportService reportService=new ReportServiceImpl();
            Reportdto reportdto = reportService.search(id);
            if (reportdto!=null) {
                ObservableList<Reportdto> data=FXCollections.observableArrayList();
               data.add(reportdto);
                tblRecord.setItems(data);
                System.out.println(data);
            }else{
                alert(Alert.AlertType.NONE,"Not Found","Student result cannot be found");
                
            }        
    }

    public void initialize(){
        
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        colCourse.setCellValueFactory(new PropertyValueFactory<>("course"));
        colGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        tblRecord.setItems(FXCollections.observableArrayList());
    
    }

    @FXML
    void btnScheduleOnAction(ActionEvent event) throws IOException {
        Stage stage=(Stage)btnSchedule.getScene().getWindow();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/information.fxml"));
        Parent root=loader.load();

        Stage stage4=new Stage();
        stage4.setScene(new Scene(root));
        stage4.setTitle("Student Time Table");
        stage4.show();
    }
}
