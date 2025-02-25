package controller;

import db.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController {
    @FXML
    private Button btnCreateAccount;

    @FXML
    private Button btnSignIn;

    @FXML
    private CheckBox rememberCheckBox;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    public void initialize(){
        btnCreateAccount.setOnMouseEntered(event -> {
            btnCreateAccount.setStyle( "-fx-background-color:   rgba(255, 255, 255, 0.001); " +
                            "-fx-text-fill:  #5e1eaa;"+
                           "-fx-border-radius:4px;"+
                           "-fx-cursor:hand;"); 
        });
    
        btnCreateAccount.setOnMouseExited(event -> {
            btnCreateAccount.setStyle( "-fx-background-color:   rgba(255, 255, 255, 0.001); " +
                           "-fx-text-fill:  #29257b;"+
                           "-fx-border-radius:4px;"); 
        });
    }
    @FXML
    void btnCreateAccountOnAction(ActionEvent event) throws IOException {
        System.out.println("==========");
        Stage currentStage = (Stage) btnCreateAccount.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/checkPrerequisites.fxml"));
        Parent root = loader.load();
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.setTitle("Check Prerequisites Page");
        newStage.show();
        currentStage.close();
    }

    
    @FXML
    void btnSignInOnAction(ActionEvent event) throws IOException {
     String user_name = txtUserName.getText();
        String password = txtPassword.getText();
    
    if (authenticateUser(user_name, password)) {
        System.out.println("Login successful!");
        try {
            Stage stage = (Stage) btnSignIn.getScene().getWindow();
            FXMLLoader loader;

            
            if (isAdmin(user_name)) {
                loader = new FXMLLoader(getClass().getResource("../view/admin.fxml"));
                Parent root1 = loader.load();
                Stage stage2 = new Stage();
                stage2.setScene(new Scene(root1));
                stage2.setTitle("Admin Page");
                stage2.show();
                stage.close();
            } else if (isStudent(user_name)) {
                loader = new FXMLLoader(getClass().getResource("../view/report.fxml"));
                Parent root = loader.load();
                Stage stage1 = new Stage();
                stage1.setScene(new Scene(root));
                stage1.setTitle("Student Report Page");
                stage1.show();
                stage.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error navigating to the page.");
        }
    } else {
        System.out.println("Invalid username or password.");
        Alert alert = new Alert(Alert.AlertType.ERROR, "The username or password is incorrect");
        alert.showAndWait();
        clearForm();
    }
}


public static boolean authenticateUser(String user_name, String password) {
    String query = "SELECT password FROM login WHERE user_name=?";
    try (Connection connection = DBConnection.getInstance().getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {

        statement.setString(1, user_name);
        ResultSet rst = statement.executeQuery();

        if (rst.next()) {
            String storedHash = rst.getString("password");
            if (password.equals(storedHash)) {
                return true; 
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
        return false; 
    }


        private boolean isAdmin(String user_name) {
            return user_name.startsWith("A") || user_name.startsWith("C"); 
        }


        private boolean isStudent(String user_name) {
                return user_name.startsWith("S"); 
        }       

        public void clearForm(){
            txtUserName.setText("");
            txtPassword.setText("");
        }

        
        
}
