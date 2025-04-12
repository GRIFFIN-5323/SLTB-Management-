package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.EmergencyDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmergencyModel {

    public String saveEmergency(EmergencyDto emergencyDto) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();

        String sql="INSERT INTO Emergency VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,emergencyDto.getIncidentId());
        preparedStatement.setString(2,emergencyDto.getDate());
        preparedStatement.setString(3,emergencyDto.getLocation());
        preparedStatement.setString(4,emergencyDto.getType());
        preparedStatement.setString(5,emergencyDto.getActionTaken());
        preparedStatement.setString(6,emergencyDto.getBusId());


        return preparedStatement.executeUpdate()>0 ? "Added Successfully" : "Added Failed";
    }


    public String updateEmergency(EmergencyDto emergencyDto) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();

        String sql="UPDATE Emergency SET date=?,location=?,type=?,actionTaken=?,busId=? WHERE id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setString(1,emergencyDto.getDate());
        preparedStatement.setString(2,emergencyDto.getLocation());
        preparedStatement.setString(3,emergencyDto.getType());
        preparedStatement.setString(4,emergencyDto.getActionTaken());
        preparedStatement.setString(5,emergencyDto.getBusId());
        preparedStatement.setString(6,emergencyDto.getIncidentId());


        return preparedStatement.executeUpdate()>0 ? "Updated Successfully" : "Updated Failed";
    }


    public String deleteEmergency(String incidentId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();

        String sql="DELETE FROM Emergency WHERE id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setString(1,incidentId);


        return preparedStatement.executeUpdate()>0 ? "Deleted Successfully" : "Deleted Failed";
    }

    public EmergencyDto searchEmergency(String incidentId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();

        String sql="SELECT * FROM Emergency WHERE id=? ";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setString(1,incidentId);
        ResultSet rst=preparedStatement.executeQuery();

        if(rst.next()){
            EmergencyDto emergencyDto=new EmergencyDto(rst.getString("incident_id"),rst.getString("date"),rst.getString("location"),rst.getString("type"),rst.getString("action_taken"),rst.getString("bus_id"));
            return emergencyDto;
        }

        return null;



    }


    public ArrayList<EmergencyDto> getAllEmergency(String incidentId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();

        String sql="SELECT * FROM Emergency";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

       ArrayList<EmergencyDto> emergencyDtos=new ArrayList<>();
        ResultSet rst=preparedStatement.executeQuery();

        while(rst.next()){
            EmergencyDto emergencyDto=new EmergencyDto(rst.getString("incident_id"),rst.getString("date"),rst.getString("location"),rst.getString("type"),rst.getString("action_taken"),rst.getString("bus_id"));
            emergencyDtos.add(emergencyDto);
        }

        return emergencyDtos;



    }





}
