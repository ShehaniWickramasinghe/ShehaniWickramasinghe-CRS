package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class adminController {
    @FXML
    private Button btnStudentProgress;

     @FXML
    private Button btnCourse;

    @FXML
    private Button btnStudent;

    @FXML
    private Button btnCourseReport;

    @FXML
    void btnCourseOnAction(ActionEvent event)throws Exception {
            Stage stage=(Stage)btnCourse.getScene().getWindow();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/course.fxml"));
            Parent root=loader.load();

            Stage stage1=new Stage();
            stage1.setScene(new Scene(root));
            stage1.setTitle("Couse page");
            stage1.show();
            stage.close();
    }

    @FXML
    void btnStudentOnAction(ActionEvent event)throws Exception {
        Stage stage=(Stage)btnStudent.getScene().getWindow();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/report.fxml"));
        Parent root=loader.load();

        Stage stage1=new Stage();
        stage1.setScene(new Scene(root));
        stage1.show();
        stage.close();
    }

    @FXML
    void btnStudentProgressOnAction(ActionEvent event) throws IOException {
        Stage stage=(Stage)btnStudentProgress.getScene().getWindow();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/private.fxml"));
        Parent root=loader.load();

        Stage stage1=new Stage();
        stage1.setScene(new Scene(root));
        stage1.setTitle("Private Page");
        stage1.show();
        stage.close();
    }

    @FXML
    void btnCourseReportOnAction(ActionEvent event) throws IOException {
        Stage stage=(Stage)btnStudentProgress.getScene().getWindow();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/courseReport.fxml"));
        Parent root=loader.load();

        Stage stage1=new Stage();
        stage1.setScene(new Scene(root));
        stage1.setTitle("Course Report Page");
        stage1.show();
        stage.close(); 
    }


}
