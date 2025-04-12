package lk.sltb.sltbmanagement.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.sltb.sltbmanagement.dto.AttendanceDto;
import lk.sltb.sltbmanagement.model.AttendanceModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AttendanceViewController {
    public TableView tblAttendence;
    AttendanceModel attendanceModel=new AttendanceModel();
    public TextField txtattendId;
    public TextField txtStatus;
    public TextField txtDate;
    public TextField txtEmpId;




    public String  saveAttendance(AttendanceDto attendanceDto) throws SQLException, ClassNotFoundException {
        String resp= attendanceModel.saveAttendance(attendanceDto);
        return resp;
    }

    public String  updateAttendance(AttendanceDto attendanceDto) throws SQLException, ClassNotFoundException {
        String resp= attendanceModel.updateAttendance(attendanceDto);
        return resp;
    }

    public String  deletettendance(String attendId) throws SQLException, ClassNotFoundException {
        String resp= attendanceModel.deleteAttendance(attendId);
        return resp;
    }



    public void add(ActionEvent actionEvent) {



        try {
            AttendanceDto attendanceDto = new AttendanceDto(txtattendId.getText(), txtStatus.getText(), txtDate.getText(), txtEmpId.getText());
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



    }
}
