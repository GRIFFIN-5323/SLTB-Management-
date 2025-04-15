package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.AttendanceDto;
import lk.sltb.sltbmanagement.dto.EmployeeAttendFineDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EmployeeAttendFineModel {

    public void addAttendFine(EmployeeAttendFineDto employeeAttendFineDto, ArrayList<AttendanceDto> attendanceDtos) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql="INSERT INTO Employee_Attend_Fine VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(2,employeeAttendFineDto.getReason());

        for(AttendanceDto attendanceDto:attendanceDtos){
            String attendTime=attendanceDto.getTime();
            LocalTime time = LocalTime.parse(attendTime);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(attendTime, formatter);



        }







    }
}