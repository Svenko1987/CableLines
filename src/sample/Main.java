package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import sample.scenes.CreateScene;

public class Main extends Application {
    Stage Window;
    Scene CreationScene, InputScene, TotalScene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Window=primaryStage;

        CreateScene cS=new CreateScene();
        Window.setScene(cS.getCreateScene());
        Window.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
