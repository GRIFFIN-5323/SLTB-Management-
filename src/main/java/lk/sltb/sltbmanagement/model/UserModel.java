package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserModel {

    public String saveUser(UserDto userDto) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="INSERT INTO User VALUES(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,userDto.getUser_id());
        preparedStatement.setString(2,userDto.getName());
        preparedStatement.setString(3,userDto.getAddress());
        preparedStatement.setString(4,userDto.getRole());
        preparedStatement.setString(5,userDto.getEmail());
        preparedStatement.setString(6,userDto.getContact());
        preparedStatement.setString(7,userDto.getPassword());

        return preparedStatement.executeUpdate() > 0 ? "Saved successfully" : "Save failed";


    }

    public String updateUser(UserDto userDto) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="UPDATE User SET name=?,address=?,role=?,email=?,contact=?,password=? WHERE user_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setString(1,userDto.getName());
        preparedStatement.setString(2,userDto.getAddress());
        preparedStatement.setString(3,userDto.getRole());
        preparedStatement.setString(4,userDto.getEmail());
        preparedStatement.setString(5,userDto.getContact());
        preparedStatement.setString(6,userDto.getPassword());
        preparedStatement.setString(7,userDto.getUser_id());

        return preparedStatement.executeUpdate() > 0 ? "Updated successfully" : "Updated failed";


    }

    public String deleteUser(String userId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="DELETE FROM User WHERE user_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setString(1,userId);


        return preparedStatement.executeUpdate() > 0 ? "Deleted successfully" : "Deleted failed";


    }

    public UserDto searchUser(String userId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM User WHERE user_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setString(1,userId);

        ResultSet resultSet=preparedStatement.executeQuery();

        if(resultSet.next()){

            UserDto userDto=new UserDto(resultSet.getString("user_id"),resultSet.getString("name"),resultSet.getString("address"),resultSet.getString("role"),resultSet.getString("email"),resultSet.getString("contact"),resultSet.getString("password"));
            return userDto;
        }
        return null;





    }

    public ArrayList<UserDto> getAllUser(String userId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM User WHERE user_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setString(1,userId);
ArrayList<UserDto> userDtos=new ArrayList<>();
        ResultSet resultSet=preparedStatement.executeQuery();

        while(resultSet.next()){

            UserDto userDto=new UserDto(resultSet.getString("user_id"),resultSet.getString("name"),resultSet.getString("address"),resultSet.getString("role"),resultSet.getString("email"),resultSet.getString("contact"),resultSet.getString("password"));
            userDtos.add(userDto);
        }
        return userDtos;





    }









}
