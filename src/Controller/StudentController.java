package controller;

import dto.Studentdto;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.custom.StudentService;
import service.custom.impl.StudentServiceImpl;

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
    private ComboBox<String> Semester1;

    @FXML
    private ComboBox<String> Semester2;

    @FXML
    private TextField txtStudentId;

    @FXML
    private TextField txtStudentName;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnGoBack;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    
    public void initialize(){
        List<String> sem1 = Arrays.asList("Inorganic",
        "Relative motion", "Radioactivity",  
         "Robotics", "Operating Systems", "OOP", "Nuclear Reaction");
        ObservableList<String> semester1 = FXCollections.observableArrayList(sem1);
        Semester1.setItems(semester1);
        Semester1.setValue("Inorganic");

        List<String> sem2=Arrays.asList("Organic", "Operating Systems","Statistics and Probability","Optics", "CyberSecurity"
        ,"Nuclear Reaction","React");
        ObservableList<String> semester2 = FXCollections.observableArrayList(sem2);
        Semester2.setItems(semester2);
        Semester2.setValue("Organic");


    }
    
        @FXML
        void btnSaveOnAction(ActionEvent event) throws Exception {
                String studentId=txtStudentId.getText();
                String name=txtStudentName.getText();
                LocalDate DOB=txtDOB.getValue();
                String phoneNo =txtPhoneNo.getText();
                String email=txtEmail.getText();
    
                if (email.contains("@") && email.contains(".")) {
                    email=txtEmail.getText();
                }else{
                   alert(Alert.AlertType.ERROR, "ERROR", "Please enter a correct email address.");
                    return;
                }
                String sem1 = Semester1.getValue();
                ObservableList<String> semester1 = FXCollections.observableArrayList(sem1);
                String sem2 = Semester2.getValue();
                ObservableList<String> semester2 = FXCollections.observableArrayList(sem2);
                Studentdto studentdto=new Studentdto(studentId, name, DOB, phoneNo, email, semester1,semester2);
                StudentService studentService=new StudentServiceImpl();
                String save = studentService.save(studentdto);
                System.out.println(studentdto);
                clearForm();
        }
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
    void btnDeleteOnAction(ActionEvent event) throws Exception {
        
        if (txtStudentId!=null) {
            Alert alert=new Alert(Alert.AlertType.WARNING,"Do you want to delete your details?");
            alert.show();
            StudentService studentService=new StudentServiceImpl();
            String delete = studentService.delete(txtStudentId.getText());
            clearForm();
        }else{
            Alert alert=new Alert(Alert.AlertType.NONE,"Student not found!");
            alert.showAndWait();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event)throws Exception {
       String id = txtStudentId.getText();
       String name = txtStudentName.getText();
       LocalDate DOB = txtDOB.getValue();
       String phone = txtPhoneNo.getText();
       String email = txtEmail.getText();
       String sem1 = Semester1.getValue();
       ObservableList<String> semester1 = FXCollections.observableArrayList(sem1);
       String sem2 = Semester2.getValue();
       ObservableList<String> semester2 = FXCollections.observableArrayList(sem2);
       Studentdto studentdto=new Studentdto(id, name, DOB, phone, email, semester1,semester2);
       StudentService studentService=new StudentServiceImpl();
       String update = studentService.update(studentdto);
       System.out.println(studentdto);
       clearForm();
    }
    @SuppressWarnings("unused")
    private void alert(Alert.AlertType alertType,String header,String content){
        Alert alert=new Alert(alertType);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void clearForm(){
        txtStudentId.setText("");
        txtStudentName.setText("");
        txtDOB.setValue(null);
        txtEmail.setText("");
        txtPhoneNo.setText("");
        Semester1.setValue(null);
        Semester2.setValue(null);
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) throws Exception {
            String id = txtStudentId.getText();
            StudentService studentService=new StudentServiceImpl();
            Studentdto studentdto=studentService.search(id);
            
            if (studentdto!=null) {
              txtStudentId.setText(studentdto.getStudentId());
              txtStudentName.setText(studentdto.getName());
              txtDOB.setValue(studentdto.getDOB());
              txtPhoneNo.setText(studentdto.getPhoneNumber());
              txtEmail.setText(studentdto.getEmail());
             
              ObservableList<String> semester1 = FXCollections.observableArrayList(studentdto.getSemester1());
              Semester1.setItems(semester1);
              ObservableList<String> semester2 = FXCollections.observableArrayList(studentdto.getSemester2());
              Semester2.setItems(semester2);
              
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING, "Student not found!", ButtonType.OK);
                 alert.showAndWait();
            }
    }
}
