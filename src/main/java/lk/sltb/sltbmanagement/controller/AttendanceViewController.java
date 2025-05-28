package lk.sltb.sltbmanagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import lk.sltb.sltbmanagement.dto.AttendanceDto;
import lk.sltb.sltbmanagement.dto.EmployeeDto;
import lk.sltb.sltbmanagement.dto.tm.AttendanceTM;
import lk.sltb.sltbmanagement.model.AttendanceModel;
import lk.sltb.sltbmanagement.model.EmployeeModel;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AttendanceViewController implements Initializable {


    public TableView<AttendanceTM> tblAttendance;
    public TableColumn<AttendanceTM,String> colEmpId;
    public TableColumn<AttendanceTM,String> colName;
    public TableColumn<AttendanceTM,String> colTime;
    public TableColumn <AttendanceTM,String>colStatus;
    private final EmployeeModel employeeModel=new EmployeeModel();
    public TableColumn <AttendanceTM,String>colNote;
    public JFXButton btnSaveAttendance;
    public DatePicker date;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblAttendance.setEditable(true);
        colStatus.setEditable(true);
        colEmpId.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("empName"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("attendTime"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        try {


            loadTableData();

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error").show();

        }



    }


    private void loadTableData() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeDto> employeeDtos= employeeModel.getAllEmployee();
        ObservableList<AttendanceTM> attendanceTMS = FXCollections.observableArrayList();

        for (EmployeeDto employeeDto : employeeDtos) {
            AttendanceTM attendanceTM = new AttendanceTM(employeeDto.getEmp_id(),employeeDto.getName(),null,FXCollections.observableArrayList("Present","Late","Absent"),null);

            attendanceTMS.add(attendanceTM);
        }
        tblAttendance.setItems(attendanceTMS);
    }

    public void SaveOnAction(ActionEvent actionEvent) {
        AttendanceModel attendanceModel = new AttendanceModel();

        LocalDate today = LocalDate.now();
        String attendDate = today.toString(); // "yyyy-MM-dd"
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        for (AttendanceTM tm : tblAttendance.getItems()) {
            String id = tm.getEmpId();
            String status = String.valueOf(tm.getStatus()); // Already a string if properly set
            String time = tm.getAttendTime();



            AttendanceDto attendanceDto = new AttendanceDto(null,status,attendDate,time,id);

            try {
                boolean isSaved = attendanceModel.saveAttendance(attendanceDto);

                if (!isSaved) {
                    new Alert(Alert.AlertType.ERROR, "Failed to save: " + id).show();
                }

            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Error saving data for " + id + ": " + e.getMessage()).show();
            }
        }

        new Alert(Alert.AlertType.INFORMATION, "Attendance saved successfully!").show();
    }
    }
















