package controller;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VacanciesController {
            @FXML
    private Button btnRegister;

    @FXML
    void btnRegisterOnAction(ActionEvent event)throws IOException {
            Stage stage=(Stage)btnRegister.getScene().getWindow();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/student.fxml"));
            Parent root=loader.load();

            Stage stage1=new Stage();
            stage1.setScene(new Scene(root));
            stage1.show();
            stage.close();
    }

    public void initialize() {

        btnRegister.setOnMouseEntered(event -> btnRegister.setStyle("-fx-background-color: #00A5A5;"));
        
        btnRegister.setOnMouseExited(event -> btnRegister.setStyle("-fx-background-color: #008080;"));
    }
}
