package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.EmpViolationDto;
import lk.sltb.sltbmanagement.dto.EmployeeDto;
import lk.sltb.sltbmanagement.dto.ViolationDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpViolationModel {


    public String addEmpViolation(EmpViolationDto empViolationDto, ViolationDto violationDto, ArrayList<EmployeeDto> employeeDtos) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getInstance().getConnection();


        try {
            connection.setAutoCommit(false);

            double violationAmount;

            if (violationDto.getType().contains("Traffic Violation")) {
                violationAmount = 100;
            } else if (violationDto.getType().contains("Conduct Violation")) {
                violationAmount = 200;
            } else if (violationDto.getType().contains("Safety Violation")) {
                violationAmount = 300;

            } else {
                violationAmount = 50;
            }

            String sql = "INSERT INTO Emp_Violation VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, empViolationDto.getEmp_violation_id());
            preparedStatement.setString(2, empViolationDto.getDate());
            preparedStatement.setString(3, empViolationDto.getDescription());
            preparedStatement.setDouble(4, violationAmount);
            preparedStatement.setString(5, empViolationDto.getEmpId());
            preparedStatement.setString(6, empViolationDto.getViolationId());


            boolean violationSaved = preparedStatement.executeUpdate() > 0;

            if (violationSaved) {
                String pointSql = "UPDATE Employee SET emp_point=(emp_point+1) WHERE emp_id=? ";
                boolean addPoint = true;

                for (EmployeeDto employeeDto : employeeDtos) {
                    PreparedStatement pointStmt = connection.prepareStatement(pointSql);
                    pointStmt.setString(1, employeeDto.getEmp_id());


                    if (!(pointStmt.executeUpdate() > 0)) {
                        addPoint = false;
                    }

                }

                if (addPoint) {
                    connection.commit();
                    return "Success";

                } else {
                    connection.rollback();
                    return "Fail";



            }

            } else{
                connection.rollback();
                return "Fail to Add Emp_Violation";
            }

        } catch (SQLException e) {
            connection.rollback();


            throw e;

        } finally {
            connection.setAutoCommit(true);


        }


    }



    public String updateEmpViolation(EmpViolationDto empViolationDto) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getInstance().getConnection();




        String sql = "UPDATE Emp_Violation SET date=?,description=?,empId=?,violationId=? WHERE empViolation_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        preparedStatement.setString(1, empViolationDto.getDate());
        preparedStatement.setString(2, empViolationDto.getDescription());
        preparedStatement.setString(3, empViolationDto.getEmpId());
        preparedStatement.setString(4, empViolationDto.getViolationId());
        preparedStatement.setString(5, empViolationDto.getEmp_violation_id());

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
