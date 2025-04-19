package lk.sltb.sltbmanagement.controller;

import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.sltb.sltbmanagement.dto.AttendanceDto;
import lk.sltb.sltbmanagement.model.AttendanceModel;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AttendanceViewController {
    public TableView tblAttendence;
    public TextField txtTime;
    public JFXCheckBox checkAttend;
    AttendanceModel attendanceModel=new AttendanceModel();
    public TextField txtattendId;
    public TextField txtStatus;
    public TextField txtDate;
    public TextField txtEmpId;




    public String  saveAttendance(AttendanceDto attendanceDto) throws SQLException, ClassNotFoundException {
        String resp= attendanceModel.saveAttendance(attendanceDto);
        return resp;
    }


    public String  deletettendance(String attendId) throws SQLException, ClassNotFoundException {
        String resp= attendanceModel.deleteAttendance(attendId);
        return resp;
    }



    public void add(ActionEvent actionEvent) {



        try {
            AttendanceDto attendanceDto = new AttendanceDto(txtattendId.getText(), txtStatus.getText(), txtDate.getText() ,txtEmpId.getText(),txtTime.getText());
            String resp=saveAttendance(attendanceDto);
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.INFORMATION, "Done").show();


        }


    }

    public void update(ActionEvent actionEvent) {

    }

    public void delete(ActionEvent actionEvent) {

        String attendId=txtattendId.getText();
        try{
            String resp=deletettendance(attendId);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public void initialize() {
        setCurrentTime();
        setCurrentDate();




    }

    private void setCurrentTime() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        txtTime.setText(now.format(formatter));
    }

    private void setCurrentDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        txtDate.setText(today.format(formatter));
    }

    public void fillStatus(ActionEvent actionEvent) {

        if (checkAttend.isSelected()) {
            txtStatus.setText("Present");
        } else {
            txtStatus.setText("Absent");
        }
    }
}
