package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.ViolationDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViolationModel {

    public String saveViolation(ViolationDto violationDto) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="INSERT INTO Violation VALUES(?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,violationDto.getViolation_id());
        preparedStatement.setString(2,violationDto.getDescription());
        preparedStatement.setString(3,violationDto.getType());

        return preparedStatement.executeUpdate()>0 ? "Saved Successfully" : "Saved Failed";
    }

    public String updateViolation(ViolationDto violationDto) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="UPDATE Violation SET description=?, type=? WHERE Violation_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setString(1,violationDto.getDescription());
        preparedStatement.setString(2,violationDto.getType());
        preparedStatement.setString(3,violationDto.getViolation_id());

        return preparedStatement.executeUpdate()>0 ? "Updated Successfully" : "Updated Failed";
    }

    public String deleteViolation(String violationId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="UPDATE Violation SET description=?, type=? WHERE Violation_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setString(1,violationId);


        return preparedStatement.executeUpdate()>0 ? "Deleted Successfully" : "Deleted Failed";
    }

    public ViolationDto searchViolation(String violationId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM Violation WHERE Violation_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setString(1,violationId);

        ResultSet resultSet=preparedStatement.executeQuery();

        if(resultSet.next()){
            ViolationDto violationDto=new ViolationDto(resultSet.getString("violation_id"),resultSet.getString("description"),resultSet.getString("type"));
            return violationDto;
        }
        return null;



    }

    public ArrayList<ViolationDto> getAllViolation(String violationId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM Violation ";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);


 ArrayList<ViolationDto> violationDtos=new ArrayList<>();
        ResultSet resultSet=preparedStatement.executeQuery();

        while(resultSet.next()){
            ViolationDto violationDto=new ViolationDto(resultSet.getString("violation_id"),resultSet.getString("description"),resultSet.getString("type"));
            violationDtos.add(violationDto);
        }
        return violationDtos;




    }







}
