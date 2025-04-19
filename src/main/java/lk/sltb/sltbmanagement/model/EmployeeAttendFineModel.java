package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.AttendanceDto;
import lk.sltb.sltbmanagement.dto.EmployeeAttendFineDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EmployeeAttendFineModel {

    public void addAttendFine(EmployeeAttendFineDto employeeAttendFineDto, ArrayList<AttendanceDto> attendanceDtos) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();




        LocalTime eightAM = LocalTime.of(8, 0);



        for(AttendanceDto attendanceDto : attendanceDtos){
            if(attendanceDto.getStatus().equals("Present")){
                LocalTime attendTime = LocalTime.parse(attendanceDto.getTime(), DateTimeFormatter.ofPattern("HH:mm:ss"));
                Duration duration = Duration.between(eightAM, attendTime);

                double minutes = duration.toMinutes();

                double fine= minutes*2;

                if(minutes >0) {


                    String sql = "INSERT INTO VALUES Employee_Attend_Fine (?,?,?,?,?,?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);

                    preparedStatement.setString(1, attendanceDto.getAttendId());
                    preparedStatement.setString(2, employeeAttendFineDto.getReason());
                    preparedStatement.setDouble(3, minutes);
                    preparedStatement.setDouble(4, fine);
                    preparedStatement.setString(5, attendanceDto.getTime());
                    preparedStatement.setString(6, attendanceDto.getAttendId());

                    preparedStatement.executeUpdate();


                }













            }
        }










    }
}