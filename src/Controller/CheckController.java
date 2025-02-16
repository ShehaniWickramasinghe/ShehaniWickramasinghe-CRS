package controller;

import java.io.IOException;

import dto.Checkdto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.custom.CheckService;
import service.custom.impl.CheckServiceImpl;

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
    void bthSearchOnAction(ActionEvent event) throws Exception {
            String name = txtCourseName.getText();
            CheckService checkService=new CheckServiceImpl();
            Checkdto checkdto = checkService.search(name);
            if (checkdto!=null) {
                txtCourseName.setText(checkdto.getName());
                lblTextPrerequisites.setText(checkdto.getPrerequisites());
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING, "Course not found!", ButtonType.OK);
                 alert.showAndWait();
            }
    }

    @FXML
    void btnNoOnAction(ActionEvent event) throws IOException {
            Stage stage=(Stage)btnNo.getScene().getWindow();
             FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/report.fxml"));
            Parent root=loader.load();
            
                        Alert alert=new Alert(Alert.AlertType.WARNING,"This course can not allow you to register");
                        alert.showAndWait();

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
