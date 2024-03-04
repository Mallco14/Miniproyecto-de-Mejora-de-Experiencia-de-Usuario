package hunt.software.gestionradios;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.IOException;


public class mainSoftware extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainSoftware.class.getResource("viewSoftware.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 780, 560);
        stage.setResizable(false);
        stage.setTitle("Gestor de Inventario Radios - NAME V.1.0");
        stage.setScene(scene);
        stage.getIcons().add(new Image(""));
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}