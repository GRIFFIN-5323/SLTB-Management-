package lk.sltb.sltbmanagement;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.sltb.sltbmanagement.DBConnection.DBConnection;

import java.sql.SQLException;

public class AppInitializer  extends Application {



    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/AttendanceView.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();






    }
}
