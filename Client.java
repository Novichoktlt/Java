package lesson2_4.online;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Client extends Application {



    public static void main(String[] args) {

        launch(args);
    }

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        scene = new Scene(loadFxml("chat.fxml"), 400, 600);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("g512.png")));
        primaryStage.setTitle("Бла-Бла-Чат");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private static Parent loadFxml(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource(fxml));
        return fxmlLoader.load();
    }
}
