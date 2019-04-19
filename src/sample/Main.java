package sample;

import database.DBHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view2.fxml"));
        Parent root = loader.load();

        // получить ссылку на контроллер
        Controller controller = loader.getController();
        // передать stage в контроллер
        controller.setStage(primaryStage);

        primaryStage.setTitle("Dozer Control - Просмотр пасспорта");
        primaryStage.setScene(new Scene(root, 900, 600));

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
        //DBHelper.getDataFromDB("SELECT * FROM brands WHERE brand_id = 4");
    }
}
