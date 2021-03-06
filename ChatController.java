package lesson2_4.online;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    @FXML
    public TextArea chatArea;
    @FXML
    public ListView onlineUsers;
    @FXML
    public Button btnSendMessage;
    @FXML
    public TextField input;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        onlineUsers.setItems(FXCollections.observableArrayList("Вася", "Петя"));
    }
    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void showHelp(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI("https://docs.google.com/document/d/1wr0YEtIc5yZtKFu-KITqYnBtp8KC28v2FEYUANL0YAM/edit#"));
    }




    public void Item(ActionEvent actionEvent) {

    }


    public void pressEnter(ActionEvent actionEvent) {
        appendTextFromTF();
    }

    public void btnSend(ActionEvent actionEvent) {
        appendTextFromTF();
    }

    private void appendTextFromTF(){
        String msg = input.getText();
        if(msg.length() > 0) {
            chatArea.appendText(msg + System.lineSeparator());
            input.clear();
        }
    }


    public void aboutTheProgram(ActionEvent actionEvent) {

    }

    public void textSize(ActionEvent actionEvent) {

    }

    public void minimizeToTrade(ActionEvent actionEvent) {

    }

    public void fullScreen(ActionEvent actionEvent) {

    }

    public void topWindows(ActionEvent actionEvent) {

    }

    public void connection(ActionEvent actionEvent) {

    }

    public void onlineStatus(ActionEvent actionEvent) {

    }

    public void profile(ActionEvent actionEvent) {

    }
}
