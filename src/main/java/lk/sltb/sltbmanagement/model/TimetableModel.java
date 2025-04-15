package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.TimetableDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TimetableModel {
    public String saveTimetable(TimetableDto timetableDto) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="INSERT INTO Timetable VALUES ( ?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,timetableDto.getTimetableId());
        preparedStatement.setString(2,timetableDto.getDepartureLocation());
        preparedStatement.setString(3,timetableDto.getArrivalLocation());
        preparedStatement.setString(4,timetableDto.getArrivalTime());
        preparedStatement.setString(5,timetableDto.getDepartureTime());

        return preparedStatement.executeUpdate() > 0 ? "Saved Successfully" : "Saved Failed";


    }

    public String updateTimetable(TimetableDto timetableDto) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="UPDATE Timetable SET timetable_id=?, departure_location=?,arrival_location=?,arrival_time=?,departure_time=? WHERE timetable_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setString(1,timetableDto.getDepartureLocation());
        preparedStatement.setString(2,timetableDto.getArrivalLocation());
        preparedStatement.setString(3,timetableDto.getArrivalTime());
        preparedStatement.setString(4,timetableDto.getDepartureTime());
        preparedStatement.setString(5,timetableDto.getTimetableId());

        return preparedStatement.executeUpdate() > 0 ? "Updated Successfully" : "Updated Failed";


    }

    public String deleteTimetable(String timetableId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="DELETE FROM Timetable WHERE timetable_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,timetableId);


        return preparedStatement.executeUpdate() > 0 ? "Deleted Successfully" : "Deleted Failed";


    }

    public TimetableDto searchTimetable(String timetableId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM Timetable WHERE timetable_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,timetableId);

        ResultSet resultSet=preparedStatement.executeQuery();

        if(resultSet.next()){

            TimetableDto timetableDto=new TimetableDto(resultSet.getString("timetable_id"),resultSet.getString("departure_location"),resultSet.getString("arrival_location"),resultSet.getString("arrival_time"),resultSet.getString("departure_time"));
            return timetableDto;
        }

        return null;




    }

    public ArrayList<TimetableDto> getAllTimetable(String timetableId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM Timetable ";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

ArrayList<TimetableDto> timetableDtos=new ArrayList<>();
        ResultSet resultSet=preparedStatement.executeQuery();

        while(resultSet.next()){

            TimetableDto timetableDto=new TimetableDto(resultSet.getString("timetable_id"),resultSet.getString("departure_location"),resultSet.getString("arrival_location"),resultSet.getString("arrival_time"),resultSet.getString("departure_time"));
          timetableDtos.add(timetableDto);
        }

       return timetableDtos;




    }









}
