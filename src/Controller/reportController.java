package controller;

import java.io.IOException;

import dto.Reportdto;
import entity.ReportEntity;
import java.util.List;

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
    private TableColumn<Reportdto,String> colSemester;

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
    void btnVacanciesOnAction(ActionEvent event) throws IOException {
            Stage stage=(Stage)btnVacancies.getScene().getWindow();
            FXMLLoader  loader=new FXMLLoader(getClass().getResource("../view/vacancies.fxml"));
            Parent root=loader.load();

            Stage stage1=new Stage();
            stage1.setScene(new Scene(root));
            stage1.setTitle("Vacancy Page");
            stage1.show();
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
            List<Reportdto> reportList=reportService.search(id);
            if (!reportList.isEmpty()) {
                ObservableList<Reportdto> data = FXCollections.observableArrayList(reportList);
                tblRecord.setItems(data);
            }else{
                alert(Alert.AlertType.ERROR,"Not Found","Student result cannot be found");
                tblRecord.setItems(FXCollections.observableArrayList());
        
            }        
    }

    public void initialize(){
        btnVacancies.setOnMouseEntered(event -> {
            btnVacancies.setStyle( "-fx-background-color:   rgba(255, 255, 255, 0.001); " +
                            "-fx-text-fill:  #8e1717;"+
                           "-fx-border-radius:4px;"+
                           "-fx-cursor:hand;"); 
        });
    
        btnVacancies.setOnMouseExited(event -> {
            btnVacancies.setStyle( "-fx-background-color:   rgba(255, 255, 255, 0.001); " +
                           "-fx-text-fill:  #b43d3d;"+
                           "-fx-border-radius:4px;"); 
        });
        btnProfile.setOnMouseEntered(event -> {
            btnProfile.setStyle( "-fx-background-color:   rgba(255, 255, 255, 0.001); " +
                            "-fx-text-fill:  #8e1717;"+
                           "-fx-border-radius:4px;"+
                           "-fx-cursor:hand;"); 
        });
    
        btnProfile.setOnMouseExited(event -> {
            btnProfile.setStyle( "-fx-background-color:   rgba(255, 255, 255, 0.001); " +
                                  "-fx-text-fill:  #b43d3d;"+
                           "-fx-border-radius:4px;"); 
        });
        btnSchedule.setOnMouseEntered(event -> {
            btnSchedule.setStyle( "-fx-background-color:   rgba(255, 255, 255, 0.001); " +
                            "-fx-text-fill:  #8e1717;"+
                           "-fx-border-radius:4px;"+
                           "-fx-cursor:hand;"); 
        });
    
        btnSchedule.setOnMouseExited(event -> {
            btnSchedule.setStyle( "-fx-background-color:   rgba(255, 255, 255, 0.001); " +
                           "-fx-text-fill:  #b43d3d;"+
                           "-fx-border-radius:4px;"); 
        });
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        colCourse.setCellValueFactory(new PropertyValueFactory<>("course"));
        colGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        colSemester.setCellValueFactory(new PropertyValueFactory<>("Semester"));

        tblRecord.setItems(FXCollections.observableArrayList());

        tblRecord.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) ->{
          
            if (newSelection!=null) {
                ReportEntity reportEntity=new ReportEntity(newSelection.getStudentId(), newSelection.getStudentName(),
                newSelection.getDepartment(), newSelection.getCourse(), newSelection.getSemester(), newSelection.getGrade());
            }
        }
            
        );
        
    
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

    public void update(Reportdto reportdto) throws Exception{
        ReportService reportService=new ReportServiceImpl();
        reportService.update(reportdto);
    }
}
