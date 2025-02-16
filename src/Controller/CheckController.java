package controller;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CheckController {
    @FXML
    private Button bthSearch;

    @FXML
    private Button btnNo;

    @FXML
    private Button btnYes;

    @FXML
    private Label lblCourseName;

    @FXML
    private Label lblPrerequisites;

    @FXML
    private Label lblPrerequisites1;

    @FXML
    private Label lblTextPrerequisites;

    @FXML
    private TextField txtCourseName;

   

    public void initialize() {

        btnNo.setOnMouseEntered(event -> {
            btnNo.setStyle("-fx-background-color: #00A5A5; " +
                           "-fx-border-color: #00A5A5; " +
                           "-fx-text-fill: #ffffff;"+
                           "-fx-border-radius:4px;"); 
        });
    
        btnNo.setOnMouseExited(event -> {
            btnNo.setStyle("-fx-background-color: #ffffff; " +
                           "-fx-border-color: #00A5A5; " +
                           "-fx-text-fill: #008080;"+
                           "-fx-border-radius:4px;"); 
        });

        btnYes.setOnMouseEntered(event -> {
            btnYes.setStyle("-fx-background-color: #ec2f55; " +
                           "-fx-border-color: #ec2f55; " +
                           "-fx-text-fill: #ffffff;"+
                           "-fx-border-radius:4px;"); 
        });
    
        btnYes.setOnMouseExited(event -> {
            btnYes.setStyle("-fx-background-color: #ffffff; " +
                           "-fx-border-color:  #ec2f55; " +
                           "-fx-text-fill:  #ec2f55;"+
                           "-fx-border-radius:4px;"); 
        });
    }
    

    
    @FXML
    void bthSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnNoOnAction(ActionEvent event) throws IOException {
            Stage stage=(Stage)btnNo.getScene().getWindow();
             FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/report.fxml"));
            Parent root=loader.load();

            Stage stage1=new Stage();
            stage1.setScene(new Scene(root));
            stage1.show();
            stage.close();

    }

    @FXML
    void btnYesOnAction(ActionEvent event) throws IOException {
        Stage stage=(Stage)btnYes.getScene().getWindow();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/student.fxml"));
       Parent root=loader.load();

       Stage stage1=new Stage();
       stage1.setScene(new Scene(root));
       stage1.show();
       stage.close();
    }

}
