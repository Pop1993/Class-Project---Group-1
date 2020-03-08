package sample;

import Entity.User;
import Util.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void loginButtonIsClicked () {
        String usernameFromConsole = username.getText();
        String passwordFromConsole = password.getText();

        User user = new User(usernameFromConsole, passwordFromConsole);

        if(UserService.doesUserExists(user)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("You have logged in succesfully");
            alert.show();

            //scene 2
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You have failed!!!!");
            alert.show();
        }

    }

}
