package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.AttendanceDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AttendanceModel {


    public boolean saveAttendance(AttendanceDto attendanceDto) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getInstance().getConnection();

        String sql = "INSERT INTO Attendance VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = today.format(formatter);
        LocalTime time = LocalTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeString = time.format(timeFormat);


        String nextId = getNextCustomerId();


        preparedStatement.setString(1, nextId);
        preparedStatement.setString(2, "Present");
        preparedStatement.setString(3, formattedDate);
        preparedStatement.setString(4, timeString);
        preparedStatement.setString(5, attendanceDto.getEmpId());

        return preparedStatement.executeUpdate() > 0 ;


    }


    public String deleteAttendance(String attendId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Attendance WHERE attend_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, attendId);


        return preparedStatement.executeUpdate() > 0 ? "SUCCESSFULLY DELETED" : "FAIL";


    }


    public AttendanceDto searchAttendance(String attendId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Attendance WHERE attend_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, attendId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            AttendanceDto attendanceDto = new AttendanceDto(resultSet.getString("attend_id"), resultSet.getString("status"), resultSet.getString("date"), resultSet.getString("attend_time"), resultSet.getString("empId"));
            return attendanceDto;
        }

        return null;


    }

    public ArrayList<AttendanceDto> getAllAttendance(String attendId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Attendance ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ArrayList<AttendanceDto> attendanceDtos = new ArrayList<>();


        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            AttendanceDto attendanceDto = new AttendanceDto(resultSet.getString("attend_id"), resultSet.getString("status"), resultSet.getString("date"), resultSet.getString("attend_time"), resultSet.getString("empId"));
            attendanceDtos.add(attendanceDto);
            return attendanceDtos;
        }

        return null;


    }


    public String getNextCustomerId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT attend_id from Attendance ORDER BY attend_id DESC LIMIT 1");

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            String lastIdNumberString = lastId.substring(1);
            int lastIdNumber = Integer.parseInt(lastIdNumberString);
            int nextIdNumber = lastIdNumber + 1;

            String nextIdString = String.format("A%03d", nextIdNumber);
            return nextIdString;
        }

        return "A001";


    }
}