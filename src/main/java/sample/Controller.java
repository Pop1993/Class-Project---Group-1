package sample;

import Entity.User;
import Util.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void loginButtonIsClicked (ActionEvent event) throws IOException {
        String usernameTypedByUser = username.getText();
        String passwordTypedByUser = password.getText();

        User userFromDatabase = UserService.returnUserFromDatabase(new User(usernameTypedByUser, passwordTypedByUser));

        if(UserService.doesUserExists(userFromDatabase)){

            if ("customer".equals(userFromDatabase.getUserType())) {
                Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("shop.fxml"));
                Scene scene = new Scene(parent);
                Stage appStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                appStage.setScene(scene);
                appStage.show();
            } else if ("employee".equals(userFromDatabase.getUserType())) {
                Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("employee.fxml"));
                Scene scene = new Scene(parent);
                Stage appStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                appStage.setScene(scene);
                appStage.show();
            }

//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setContentText("You have logged in succesfully");
//            alert.show();

            //the below will open the shop window, but we need to chose what type of window to open
            //depending on the type of user
//            Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("shop.fxml"));
//            Scene scene = new Scene(parent);
//            Stage appStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//            appStage.setScene(scene);
//            appStage.show();

            //scene 2
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You have failed!!!!");
            alert.show();
        }

    }

}
