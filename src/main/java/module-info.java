module lk.sltb.sltbmanagement {
    requires javafx.fxml;
    requires java.sql;
    requires com.jfoenix;
    requires javafx.controls;
    requires static lombok;


    opens lk.sltb.sltbmanagement.controller to javafx.fxml;
    opens lk.sltb.sltbmanagement.dto.tm to javafx.base;
    exports lk.sltb.sltbmanagement;
}