import database.jdbc;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class helloApp extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            //đưa file FXML vào
            FXMLLoader loader = new FXMLLoader(helloApp.class.getResource("hello.fxml"));

            //tạo kịch bản
//            helloController helloContro = new helloController();
//            loader.setController(helloContro);

            //lấy giao diện pane ra
            Pane root = loader.load();
            Scene scene = new Scene(root );

            //đưa scence lên cửa sổ chính
            primaryStage.setScene(scene);
            primaryStage.show();

            //connect database
            Connection con = jdbc.getConnection();
            con.close();
        }
        catch(Exception e) {
            System.out.println("Error:"+e.toString());
        }

    }
}
