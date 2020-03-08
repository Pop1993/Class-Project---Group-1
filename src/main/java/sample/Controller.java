package sample;

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
        if(UserService.doesUserExists(username.getText(), password.getText())){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("You have logged in succesfully");
            alert.show();
    } }

}
