package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
            Stage stage=new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/student.fxml"))));
            stage.show();
        }
        
        @FXML
        void btnTeacherOnAction(ActionEvent event)throws IOException {
            System.out.println("Add Teacher");
            Stage stage=new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/course.fxml"))));
            stage.show();
    }
}
