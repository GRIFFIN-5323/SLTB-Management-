module lk.sltb.sltbmanagement {
    requires javafx.fxml;
    requires java.sql;
    requires com.jfoenix;
    requires javafx.controls;


    opens lk.sltb.sltbmanagement.controller to javafx.fxml;
    exports lk.sltb.sltbmanagement;
}