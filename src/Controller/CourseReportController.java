package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dto.CourseReportdto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.custom.CourseReportService;
import service.custom.impl.CourseReportServiceImpl;

public class CourseReportController {
     @FXML
    private Button btnSave;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnArrow;

    @FXML
    private Label lblCompleted;

    @FXML
    private Label lblEnrolled;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPerformance;

    @FXML
    private ToggleButton ratingGroup;

    @FXML
    private RadioButton star1;

    @FXML
    private RadioButton star2;

    @FXML
    private RadioButton star3;

    @FXML
    private RadioButton star4;

    @FXML
    private RadioButton star5;

    @FXML
    private TextField txtCompleted;

    @FXML
    private TextField txtEnrolled;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPerformance;

    @FXML
    private TableColumn<CourseReportdto,Integer> colCompletedStu;

    @FXML
    private TableColumn<CourseReportdto,String> colCourseName;

    @FXML
    private TableColumn<CourseReportdto,Integer> colEnrollmentStu;

    @FXML
    private TableColumn<CourseReportdto,String> colPerformance;

    @FXML
    private TableColumn<CourseReportdto,Integer> colRate;

    @FXML
    private TableView<CourseReportdto> tblReport;

    public void clearForm(){
        txtName.setText("");
        txtEnrolled.setText("");
        txtCompleted.setText("");
        txtPerformance.setText("");
        ratingGroup.setToggleGroup(null);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws Exception {
            String name = txtName.getText();
           int enrolledStudent = Integer.parseInt(txtEnrolled.getText());
           int completedStudent = Integer.parseInt(txtCompleted.getText());
           String performance = txtPerformance.getText();
            int rating=getSelectedRating();

           CourseReportdto courseReportdto=new CourseReportdto(name, enrolledStudent, completedStudent, performance, rating);
            CourseReportService courseReportService=new CourseReportServiceImpl();
            String save = courseReportService.save(courseReportdto);
            System.out.println(save);
            loadTable();
            clearForm();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) throws Exception {
        String name = txtName.getText().trim();
        CourseReportService courseReportService=new CourseReportServiceImpl();
        CourseReportdto courseReportdto = courseReportService.search(name);
       
        if (courseReportdto!=null) {
                
                txtName.setText(courseReportdto.getName());
                txtEnrolled.setText(String.valueOf(courseReportdto.getEnrolledStudent()));
                txtCompleted.setText(String.valueOf(courseReportdto.getCompletedStudent()));
                txtPerformance.setText(courseReportdto.getPerformance());
                setRatingStars(courseReportdto.getRate());
               
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING, "Course not found!", ButtonType.OK);
                 alert.showAndWait();
            }
    }
    private void setRatingStars(int rating) {
        star1.setSelected(rating >= 1);
        star2.setSelected(rating >= 2);
        star3.setSelected(rating >= 3);
        star4.setSelected(rating >= 4);
        star5.setSelected(rating >= 5);
        updateStars();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws Exception {
        String name = txtName.getText().trim();
        int enrolledStudent = Integer.parseInt(txtEnrolled.getText());
        int completedStudent = Integer.parseInt(txtCompleted.getText());
        String performance = txtPerformance.getText().trim();
        int rating = getSelectedRating();

        CourseReportdto courseReportdto=new CourseReportdto(name, enrolledStudent, completedStudent, performance, rating);
         CourseReportService courseReportService=new CourseReportServiceImpl();
         String update = courseReportService.update(courseReportdto);
         System.out.println(update);
         loadTable();
         clearForm();
    }
    @FXML
    public void initialize() throws Exception {
        getAll();
        if (ratingGroup.getToggleGroup() != null) {
            ratingGroup.getToggleGroup().selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
                updateStars();
            });
        }

            btnSearch.setOnMouseEntered(event -> {
                btnSearch.setStyle("-fx-background-color:  #ffffff; " +
                               "-fx-border-color:  #4CA6CF; " +
                               "-fx-text-fill:  #4CA6CF;"+
                               "-fx-border-radius:4px;"+
                               "-fx-cursor:hand;"); 
            });
        
            btnSearch.setOnMouseExited(event -> {
                btnSearch.setStyle("-fx-background-color:  #4CA6CF; " +
                               "-fx-border-color: #4CA6CF; " +
                               "-fx-text-fill: #ffffff;"+
                               "-fx-border-radius:4px;"); 
            });

            btnSave.setOnMouseEntered(event -> {
                btnSave.setStyle("-fx-background-color:  #ffffff; " +
                               "-fx-border-color:   #29cb42; " +
                               "-fx-text-fill:   #29cb42;"+
                               "-fx-border-radius:4px;"+
                               "-fx-cursor:hand;"); 
            });
        
            btnSave.setOnMouseExited(event -> {
                btnSave.setStyle("-fx-background-color:   #29cb42; " +
                               "-fx-border-color:  #29cb42; " +
                               "-fx-text-fill: #ffffff;"+
                               "-fx-border-radius:4px;"); 
            });

            btnUpdate.setOnMouseEntered(event -> {
                btnUpdate.setStyle("-fx-background-color:  #ffffff; " +
                               "-fx-border-color:    #1b36a3; " +
                               "-fx-text-fill:    #1b36a3;"+
                               "-fx-border-radius:4px;"+
                               "-fx-cursor:hand;"); 
            });
        
            btnUpdate.setOnMouseExited(event -> {
                btnUpdate.setStyle("-fx-background-color:    #1b36a3; " +
                               "-fx-border-color:   #1b36a3; " +
                               "-fx-text-fill: #ffffff;"+
                               "-fx-border-radius:4px;"); 
            });

            colCourseName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colEnrollmentStu.setCellValueFactory(new PropertyValueFactory<>("enrolledStudent"));
            colCompletedStu.setCellValueFactory(new PropertyValueFactory<>("completedStudent"));
            colPerformance.setCellValueFactory(new PropertyValueFactory<>("Performance"));
            colRate.setCellValueFactory(new PropertyValueFactory<>("Rate"));

            

            tblReport.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
                System.out.println("Table row click");
                System.out.println("oldSelection:"+oldSelection);
                System.out.println("=====================");
                System.out.println("newSelection:"+newSelection);
                if (newSelection!=null) {
                 txtName.setText(newSelection.getName());
                 txtEnrolled.setText(String.valueOf(newSelection.getEnrolledStudent()));
                 txtCompleted.setText(String.valueOf(newSelection.getCompletedStudent()));
                 txtPerformance.setText(newSelection.getPerformance());
                 setRatingStars(newSelection.getRate());
                }
            });
    }

    private void updateStars() {
        int rating = getSelectedRating();
        star1.setText(rating >= 1 ? "★" : "☆");
        star2.setText(rating >= 2 ? "★" : "☆");
        star3.setText(rating >= 3 ? "★" : "☆");
        star4.setText(rating >= 4 ? "★" : "☆");
        star5.setText(rating >= 5 ? "★" : "☆");
    }

    private int getSelectedRating() {
        if (star5.isSelected()) return 5;
        if (star4.isSelected()) return 4;
        if (star3.isSelected()) return 3;
        if (star2.isSelected()) return 2;
        if (star1.isSelected()) return 1;
        return 0;
    }

    public void getAll() throws Exception{
        CourseReportService courseReportService=new CourseReportServiceImpl();
        ArrayList<CourseReportdto> all = courseReportService.getAll();
        ObservableList<CourseReportdto> observableList=FXCollections.observableArrayList();
        observableList.addAll(all);
        tblReport.setItems(observableList);
    }

     @SuppressWarnings("unchecked")
    public void loadTable(){
        try {
            tblReport.getColumns().clear();
            tblReport.getColumns().addAll(colCourseName,colEnrollmentStu,colCompletedStu,colPerformance,colRate);
            CourseReportService courseReportService=new CourseReportServiceImpl();
            ObservableList<CourseReportdto> courseList=FXCollections.observableArrayList(courseReportService.getAll());
            tblReport.setItems(courseList);
            String columns[]={"Course Name","Enr. Student","Com Student","Performance","Rate"};
            DefaultTableModel dtm=new DefaultTableModel(columns,0){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
                
            };
            tblReport.getItems();

            ArrayList<CourseReportdto> courseReportdtos=courseReportService.getAll();
            for (CourseReportdto courseReportdto : courseReportdtos) {
                Object rowData[]={courseReportdto.getName(),courseReportdto.getEnrolledStudent(),courseReportdto.getCompletedStudent(),
                courseReportdto.getPerformance(),courseReportdto.getRate()};
            dtm.addRow(rowData);
            System.out.println(courseReportdto);
            System.out.println("successfully loaded");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnArrowOnAction(ActionEvent event) throws IOException {
        Stage stage=(Stage)btnArrow.getScene().getWindow();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/admin.fxml"));
        Parent root=loader.load();

        Stage stage1=new Stage();
        stage1.setScene(new Scene(root));
        stage1.setTitle("Admin Page");
        stage1.show();
        stage.close(); 
    }
}
