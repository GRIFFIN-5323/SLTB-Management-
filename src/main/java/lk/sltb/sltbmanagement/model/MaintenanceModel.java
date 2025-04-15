package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.MaintenanceDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaintenanceModel {

    public String saveMaintenance(MaintenanceDto maintenanceDto) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="INSERT INTO maintenance VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, maintenanceDto.getMaintenanceId());
        preparedStatement.setString(2, maintenanceDto.getDate());
        preparedStatement.setDouble(3,maintenanceDto.getCost());
        preparedStatement.setString(4,maintenanceDto.getStatus());
        preparedStatement.setString(5,maintenanceDto.getDescription());
        preparedStatement.setString(6,maintenanceDto.getBusId());


        return preparedStatement.executeUpdate()>0 ? "Successful Saved " : "Saved Failed";
    }

    public String updateMaintenance(MaintenanceDto maintenanceDto) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="UPDATE Maintenance SET date=?,cost=?,status=?,description=?,busid=? WHERE maintenance_id=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, maintenanceDto.getDate());
        preparedStatement.setDouble(2,maintenanceDto.getCost());
        preparedStatement.setString(3,maintenanceDto.getStatus());
        preparedStatement.setString(4,maintenanceDto.getDescription());
        preparedStatement.setString(5,maintenanceDto.getBusId());
        preparedStatement.setString(6, maintenanceDto.getMaintenanceId());


        return preparedStatement.executeUpdate()>0 ? "Successful Updated " : "Updated Failed";
    }

    public String deleteMaintenance(String maintenanceId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="DELETE FROM Maintenance WHERE maintenance_id=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, maintenanceId);


        return preparedStatement.executeUpdate()>0 ? "Successful Deleted " : "DeletedFailed";
    }

    public MaintenanceDto searchMaintenance(String maintenanceId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM Maintenance WHERE maintenance_id=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, maintenanceId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){


            MaintenanceDto maintenanceDto = new MaintenanceDto(resultSet.getString("maintenance_id"),resultSet.getString("date"),resultSet.getDouble("cost"),resultSet.getString("status"),resultSet.getString("description"),resultSet.getString("bus_id"));

            return maintenanceDto;
        }
 return null;


    }

    public ArrayList<MaintenanceDto> getAllMaintenance(String maintenanceId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM Maintenance ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

ArrayList<MaintenanceDto> maintenanceDtos = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){


            MaintenanceDto maintenanceDto = new MaintenanceDto(resultSet.getString("maintenance_id"),resultSet.getString("date"),resultSet.getDouble("cost"),resultSet.getString("status"),resultSet.getString("description"),resultSet.getString("bus_id"));

            maintenanceDtos.add(maintenanceDto);
        }
        return maintenanceDtos;


    }




}
