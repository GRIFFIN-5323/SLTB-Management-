package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.EmpViolationDto;
import lk.sltb.sltbmanagement.dto.ViolationDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpViolationModel {


    public String addEmpViolation(EmpViolationDto empViolationDto, ViolationDto violationDto) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getInstance().getConnection();
        double violationAmount;

        if (violationDto.getType().contains("Traffic Violation")) {
            violationAmount = 100;
        } else if (violationDto.getType().contains("Conduct Violation")) {
            violationAmount = 200;
        } else {
            violationAmount = 300;

        }

            String sql = "INSERT INTO Emp_Violation VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, empViolationDto.getEmp_violation_id());
            preparedStatement.setString(2, empViolationDto.getDate());
            preparedStatement.setString(3, empViolationDto.getDescription());
            preparedStatement.setDouble(4, violationAmount);
            preparedStatement.setString(5, empViolationDto.getEmpId());
            preparedStatement.setString(6, empViolationDto.getViolationId());

            return preparedStatement.executeUpdate() > 0 ? "saved Successfully" : "Saved Failed";


        }


    public String updateEmpViolation(EmpViolationDto empViolationDto) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getInstance().getConnection();




        String sql = "INSERT INTO Emp_Violation VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, empViolationDto.getEmp_violation_id());
        preparedStatement.setString(2, empViolationDto.getDate());
        preparedStatement.setString(3, empViolationDto.getDescription());
        preparedStatement.setString(5, empViolationDto.getEmpId());
        preparedStatement.setString(6, empViolationDto.getViolationId());

        return preparedStatement.executeUpdate() > 0 ? "saved Successfully" : "Saved Failed";


    }



    public EmpViolationDto searchEmpViolation(String empId) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getInstance().getConnection();




        String sql = "SELECT * FROM Emp_Violation WHERE emp_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, empId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            EmpViolationDto empViolationDto = new EmpViolationDto(resultSet.getString("emp_violation_id"),resultSet.getString("date"),resultSet.getString("description"),resultSet.getDouble("fine_amount"),resultSet.getString("emp_id"),resultSet.getString("violation_id"));
            return empViolationDto;
        }

        return null;




    }










}
