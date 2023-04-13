package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button Login;

    @FXML
    private TextField Password;

    @FXML
    private TextField UserName;

    @FXML
    private Label errorMessageLabel;

    private String errorMessage = "";

    private boolean isFieldFilled()
    {
        boolean isField = true;
        if (UserName.getText().isEmpty()){
            isField = false;
            errorMessage = "Username is Empty!";
        }

        if (Password.getText().isEmpty()){
            isField = false;
            if (errorMessage.isEmpty())
            {
                errorMessage = "Password is Empty!";
            }else {
                errorMessage += "\nPassword is Empty!";
            }
        }

        errorMessageLabel.setText(errorMessage);
        return isField;
    }

    private boolean isValid(){
        boolean isValid = true;
        if (!UserName.getText().equals(Main.USERNAME)){
            isValid = false;
            errorMessage = "Invalid Username!";
        }

        if (!Password.getText().equals(Main.PASSWORD)){
            isValid = false;
            if (errorMessage.isEmpty())
            {
                errorMessage = "Invalid Password!";
            }else {
                errorMessage += "\nInvalid Password";
            }
        }

        errorMessageLabel.setText(errorMessage);
        return isValid;
    }

    private void starHomeWindow(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Stage stage = new Stage();
            stage.setMaximized(true);
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Login.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                errorMessage = "";
                if (isFieldFilled() && isValid()){
                    starHomeWindow();
                }
            }
        });
    }
}
