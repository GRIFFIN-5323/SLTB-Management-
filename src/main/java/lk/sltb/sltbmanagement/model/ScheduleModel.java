package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.ScheduleDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleModel {

    public String saveSchedule(ScheduleDto scheduleDto) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="INSERT INTO Schedule VALUES(?,?,?,?,?,?,?,?,?) ";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setString(1,scheduleDto.getScheduleId());
        preparedStatement.setString(2,scheduleDto.getDate());
        preparedStatement.setString(3,scheduleDto.getDepartureTime());
        preparedStatement.setString(4,scheduleDto.getDelayReason());
        preparedStatement.setString(5,scheduleDto.getBusNum());
        preparedStatement.setString(6,scheduleDto.getArrivalTime());
        preparedStatement.setString(7,scheduleDto.getDriverName());
        preparedStatement.setString(8,scheduleDto.getConductorName());
        preparedStatement.setString(9,scheduleDto.getScheduleId());

        return preparedStatement.executeUpdate() > 0 ?"Saved Successfully" : "Saved Failed";


    }

    public String updateSchedule(ScheduleDto scheduleDto) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="UPDATE Schedule SET  date=?,departure_time=?,delay_reason=?,bus_num=?,arrival_time=?,driver_name=?,conductor_name=?,route_id=? WHERE schedule_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);


        preparedStatement.setString(1,scheduleDto.getDate());
        preparedStatement.setString(2,scheduleDto.getDepartureTime());
        preparedStatement.setString(3,scheduleDto.getDelayReason());
        preparedStatement.setString(4,scheduleDto.getBusNum());
        preparedStatement.setString(5,scheduleDto.getArrivalTime());
        preparedStatement.setString(6,scheduleDto.getDriverName());
        preparedStatement.setString(7,scheduleDto.getConductorName());
        preparedStatement.setString(8,scheduleDto.getScheduleId());
        preparedStatement.setString(9,scheduleDto.getScheduleId());

        return preparedStatement.executeUpdate() > 0 ?"Updated Successfully" : "Updated Failed";


    }

    public String deleteSchedule(String scheduleId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="DELETE FROM Schedule WHERE schedule_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);


        preparedStatement.setString(1,scheduleId);


        return preparedStatement.executeUpdate() > 0 ?"Deleted Successfully" : "Deleted Failed";


    }


    public ScheduleDto searchSchedule(String scheduleId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM Schedule WHERE schedule_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);


        preparedStatement.setString(1,scheduleId);

        ResultSet resultSet=preparedStatement.executeQuery();

        if(resultSet.next()){

            ScheduleDto scheduleDto=new ScheduleDto(resultSet.getString("schedule_id"),resultSet.getString("date"),resultSet.getString("departure_time"),resultSet.getString("delay_reason"),resultSet.getString("bus_num"),resultSet.getString("arrival_time"),resultSet.getString("driver_name"),resultSet.getString("conductor_name"),resultSet.getString("route_id"));
            return scheduleDto;
        }


       return null;

    }

    public ArrayList<ScheduleDto> getAllSchedule(String scheduleId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM Schedule WHERE schedule_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);


        preparedStatement.setString(1,scheduleId);
 ArrayList<ScheduleDto> scheduleDtos=new ArrayList<>();
        ResultSet resultSet=preparedStatement.executeQuery();

        if(resultSet.next()){

            ScheduleDto scheduleDto=new ScheduleDto(resultSet.getString("schedule_id"),resultSet.getString("date"),resultSet.getString("departure_time"),resultSet.getString("delay_reason"),resultSet.getString("bus_num"),resultSet.getString("arrival_time"),resultSet.getString("driver_name"),resultSet.getString("conductor_name"),resultSet.getString("route_id"));
            scheduleDtos.add(scheduleDto);
        }


        return scheduleDtos;

    }




}
