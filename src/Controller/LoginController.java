package controller;

import db.DBConnection;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        String user_name=txtUserName.getText();
        String password=txtPassword.getText();
        if (authenticateUser(user_name, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public static boolean authenticateUser(String user_name,String password){
        String query="SELECT password FROM login WHERE user_name=?";
        System.out.println("=============================");
        try (Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement statement=connection.prepareStatement(query))
            {   
                  statement.setString(1, user_name);
            ResultSet rst=statement.executeQuery();

            while (rst.next()) {
                String storedHash = rst.getString("password");
                if (password.equals(storedHash)) {
                    return true;
                }
            
              } 
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("=============================");
        return false;
    }

        
}
