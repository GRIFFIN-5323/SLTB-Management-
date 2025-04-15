package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.RouteDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RouteModel {
    public String saveRoute(RouteDto routeDto) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();

        String sql="INSERT INTO Route VALUES(?,?,?,?,?,?,?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, routeDto.getRouteId());
        preparedStatement.setString(2,routeDto.getRouteNum());
        preparedStatement.setDouble(3,routeDto.getFuelConsumption());
        preparedStatement.setInt(4,routeDto.getHalts());
        preparedStatement.setString(5,routeDto.getDuration());
        preparedStatement.setDouble(6,routeDto.getDistance());
        preparedStatement.setString(7,routeDto.getDepartureLocation());
        preparedStatement.setString(8,routeDto.getArrivalLocation());
        preparedStatement.setString(9,routeDto.getTimetableId());

        return preparedStatement.executeUpdate() > 0 ? "Saved Successfully " : "Saved Failed";

    }

    public String updateRoute(RouteDto routeDto) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();

        String sql="UPDATE Route SET  route_num=?,fuel_consumption=?,halts=?,duration=?,distance=?,departure_location=?,arrival_location=?,timetable_id=? WHERE route_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        preparedStatement.setString(1,routeDto.getRouteNum());
        preparedStatement.setDouble(2,routeDto.getFuelConsumption());
        preparedStatement.setInt(3,routeDto.getHalts());
        preparedStatement.setString(4,routeDto.getDuration());
        preparedStatement.setDouble(5,routeDto.getDistance());
        preparedStatement.setString(6,routeDto.getDepartureLocation());
        preparedStatement.setString(7,routeDto.getArrivalLocation());
        preparedStatement.setString(8,routeDto.getTimetableId());
        preparedStatement.setString(9, routeDto.getRouteId());

        return preparedStatement.executeUpdate() > 0 ? "Updated Successfully " : "Updated Failed";

    }

    public String deleteRoute(String routeId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();

        String sql="DELETE FROM Route WHERE route_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        preparedStatement.setString(1,routeId);


        return preparedStatement.executeUpdate() > 0 ? "Deleted Successfully " : "Deleted Failed";

    }

    public RouteDto searchRoute(String routeId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();

        String sql="SELECT * FROM Route WHERE route_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        preparedStatement.setString(1,routeId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            RouteDto routeDto = new RouteDto(resultSet.getString("route_id"),resultSet.getString("route_num"),resultSet.getDouble("fuel_consumption"),resultSet.getInt("halts"),resultSet.getString("duration"),resultSet.getDouble("distance"),resultSet.getString("departure_location"),resultSet.getString("arrival_location"),resultSet.getString("timetable_id"));
            return routeDto;
        }


       return null;

    }


    public ArrayList<RouteDto> getAllRoute(String routeId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();

        String sql="SELECT * FROM Route WHERE route_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        preparedStatement.setString(1,routeId);
        ArrayList<RouteDto> routeDtos = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            RouteDto routeDto = new RouteDto(resultSet.getString("route_id"),resultSet.getString("route_num"),resultSet.getDouble("fuel_consumption"),resultSet.getInt("halts"),resultSet.getString("duration"),resultSet.getDouble("distance"),resultSet.getString("departure_location"),resultSet.getString("arrival_location"),resultSet.getString("timetable_id"));
            routeDtos.add(routeDto);
        }


       return routeDtos;

    }







}
