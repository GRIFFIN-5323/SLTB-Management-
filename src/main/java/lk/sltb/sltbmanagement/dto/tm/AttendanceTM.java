package lk.sltb.sltbmanagement.dto.tm;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.AttendanceDto;
import lombok.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.ComboBox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AttendanceTM {

    // Getters
    @Getter
    private final String empId;
    @Getter
    private final String empName;
    private final StringProperty attendTime = new SimpleStringProperty();
   
    @Setter
    @Getter
    private ComboBox<String> status;
    @Setter
    private StringProperty note;

    public AttendanceTM(String empId, String empName, String attendTime, ObservableList<String> data,StringProperty note) {
        this.empId = empId;
        this.empName = empName;
        this.attendTime.set(attendTime);
        this.status = new ComboBox<>(data);
        this.note = note;

        this.status.setOnAction(event -> {
            String selected = this.status.getValue();
            if ("Present".equals(selected) || "Late".equals(selected)) {
                this.attendTime.set(java.time.LocalTime.now().toString());
            } else {
                this.attendTime.set(null);
            }
        });
    }

    public String getAttendTime() {
        return attendTime.get();
    }

    public StringProperty attendTimeProperty() {
        return attendTime;
    }

    public StringProperty noteProperty() {
        return note;
    }





}

