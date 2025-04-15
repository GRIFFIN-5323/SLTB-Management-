package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.BusDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BusModel {

    public String saveBus(BusDto busDto) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="INSERT INTO Bus VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, busDto.getBusId());
        preparedStatement.setString(2,busDto.getBusNumber());
        preparedStatement.setInt(3,busDto.getCapacity());
        preparedStatement.setString(4,busDto.getModel());
        preparedStatement.setString(5,busDto.getType());
        preparedStatement.setString(6,busDto.getStatus());
        preparedStatement.setString(7,busDto.getRouteId());
        preparedStatement.setString(8,busDto.getEmpId());

        return preparedStatement.executeUpdate()>0?"Saved Successfully":"Saved Failed";


    }

    public String updateBus(BusDto busDto) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="UPDATE Bus SET bus_number=?,capacity=?,model=?,type=?,status=?,route_id=?,emp_id=? WHERE bus_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,busDto.getBusNumber());
        preparedStatement.setInt(2,busDto.getCapacity());
        preparedStatement.setString(3,busDto.getModel());
        preparedStatement.setString(4,busDto.getType());
        preparedStatement.setString(5,busDto.getStatus());
        preparedStatement.setString(6,busDto.getRouteId());
        preparedStatement.setString(7,busDto.getEmpId());
        preparedStatement.setString(8, busDto.getBusId());

        return preparedStatement.executeUpdate()>0?"Updated Successfully":"Updated Failed";


    }

    public String deleteBus(String busId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="DELETE FROM Bus WHERE bus_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,busId);


        return preparedStatement.executeUpdate()>0?"Deleted Successfully":"Deleted Failed";


    }


    public BusDto searchBus(String busId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM Bus WHERE bus_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,busId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            BusDto busDto=new BusDto(resultSet.getString("bus_id"),resultSet.getString("bus_number"),resultSet.getInt("capacity"),resultSet.getString("model"),resultSet.getString("type"),resultSet.getString("status"),resultSet.getString("route_id"),resultSet.getString("emp_id"));
            return busDto;
        }

        return null;




    }

    public ArrayList<BusDto> getAllBus(String busId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM Bus WHERE bus_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,busId);
ArrayList<BusDto> busDtos=new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            BusDto busDto=new BusDto(resultSet.getString("bus_id"),resultSet.getString("bus_number"),resultSet.getInt("capacity"),resultSet.getString("model"),resultSet.getString("type"),resultSet.getString("status"),resultSet.getString("route_id"),resultSet.getString("emp_id"));
            busDtos.add(busDto);

        }

      return busDtos;




    }




}
