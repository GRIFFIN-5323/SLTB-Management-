package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.EmployeeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModel {

    public String saveEmployee(EmployeeDto employeeDto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql="INSERT INTO Employee VALUES(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,employeeDto.getEmp_id());
        preparedStatement.setString(2,employeeDto.getName());
        preparedStatement.setString(3,employeeDto.getEmail());
        preparedStatement.setString(4,employeeDto.getContact());
        preparedStatement.setInt(5,employeeDto.getEmp_point());
        preparedStatement.setString(6,employeeDto.getRole());
        preparedStatement.setString(7,employeeDto.getAddress());

        return preparedStatement.executeUpdate()>0 ? "SUCCESSFULLY ADDED" : "FAIL";



    }


    public String updateEmployee(EmployeeDto employeeDto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql="UPDATE Employee SET name=?,email=?,contact=?,emp_point=?,role=?,address=? WHERE emp_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,employeeDto.getName());
        preparedStatement.setString(3,employeeDto.getEmail());
        preparedStatement.setString(4,employeeDto.getContact());
        preparedStatement.setInt(5,employeeDto.getEmp_point());
        preparedStatement.setString(6,employeeDto.getRole());
        preparedStatement.setString(7,employeeDto.getAddress());
        preparedStatement.setString(1,employeeDto.getEmp_id());

        return preparedStatement.executeUpdate()>0 ? "SUCCESSFULLY UPDATED" : "FAIL";



    }

    public EmployeeDto searchEmployee(String employeeId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql="DELETE FROM Employee WHERE emp_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,employeeId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            EmployeeDto employeeDto=new EmployeeDto(resultSet.getString("emp_id"),resultSet.getString("name"),resultSet.getString("email"),resultSet.getString("contact"),resultSet.getInt("emp_point"),resultSet.getString("role"),resultSet.getString("address"));


          return employeeDto;


        }

        return null;







    }

    public ArrayList<EmployeeDto> getAllEmployee(String employeeId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql="DELETE FROM Employee ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

      ArrayList<EmployeeDto> employeeDtos=new ArrayList<>();

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            EmployeeDto employeeDto=new EmployeeDto(resultSet.getString("emp_id"),resultSet.getString("name"),resultSet.getString("email"),resultSet.getString("contact"),resultSet.getInt("emp_point"),resultSet.getString("role"),resultSet.getString("address"));


            employeeDtos.add(employeeDto);




        }

        return employeeDtos;







    }









}
