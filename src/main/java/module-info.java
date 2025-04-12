module lk.sltb.sltbmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens lk.sltb.sltbmanagement.controller to javafx.fxml;
    exports lk.sltb.sltbmanagement;
}