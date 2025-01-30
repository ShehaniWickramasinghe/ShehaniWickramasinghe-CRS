package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button btnCreateAccount;

    @FXML
    private Button btnSignIn;

    @FXML
    private Label lblLogin;

    @FXML
    private CheckBox rememberCheckBox;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnCreateAccountOnAction(ActionEvent event) throws IOException {
        System.out.println("==========");
        Stage currentStage = (Stage) btnCreateAccount.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/student.fxml"));
        Parent root = loader.load();
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.setTitle("Student Page");
        newStage.show();
        currentStage.close();
    }

    @FXML
    void btnSignInOnAction(ActionEvent event) {
            System.out.println("sign in");
    }

    

  

}
