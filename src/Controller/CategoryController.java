package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CategoryController {
            
    @FXML
    private Button btnStudent;

    @FXML
    private Button btnTeacher;



    @FXML
    private Label lblCreateAccount;

    @FXML
    void btnStudentOnAction(ActionEvent event) throws IOException  {
            System.out.println("Add Student");
            Stage stage= (Stage)btnStudent.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/student.fxml"));
            Parent root=loader.load();

            Stage newStage=new Stage();
            newStage.setScene(new Scene(root));
             newStage.setTitle("Student Registration Form");
             newStage.show();
             stage.close();
        }
        
        @FXML
        void btnTeacherOnAction(ActionEvent event)throws IOException {
            System.out.println("Add Teacher");
            Stage stage1=(Stage)btnTeacher.getScene().getWindow();
            FXMLLoader LOADER =new FXMLLoader(getClass().getResource("../view/course.fxml"));
            Parent root=LOADER.load();

            Stage stage4=new Stage();
            stage4.setScene(new Scene(root));
            stage4.setTitle("Teacher Form");
            stage4.show();
            stage1.close();
    }
}
