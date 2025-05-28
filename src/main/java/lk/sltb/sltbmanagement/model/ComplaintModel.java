package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.ComplaintDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComplaintModel {




    public String addComplaint(ComplaintDto complaintDto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql="INSERT INTO complaint VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,complaintDto.getComplaint_id());
        preparedStatement.setString(2,complaintDto.getUser_id());
        preparedStatement.setString(3,complaintDto.getReason());
        preparedStatement.setString(4,complaintDto.getDescription());
        preparedStatement.setString(5,complaintDto.getCompLevel());
        preparedStatement.setString(6,complaintDto.getDate());

        return preparedStatement.executeUpdate()>0?"Complaint Added":"Complaint Not Added";

    }



    public String updateComplaint(ComplaintDto complaintDto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql="UPDATE complaint SET reason=?, description=? ,comp_level=? WHERE complaint_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,complaintDto.getReason());
        preparedStatement.setString(2,complaintDto.getDescription());
        preparedStatement.setString(3,complaintDto.getCompLevel());
        preparedStatement.setString(4,complaintDto.getComplaint_id());


        return preparedStatement.executeUpdate()>0?"Complaint Updated":"Complaint Not Updated";

    }



    public String deleteComplaint(String complaintId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql="DELETE FROM complaint WHERE complaint_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,complaintId);


        return preparedStatement.executeUpdate()>0?"Complaint Deleted":"Complaint Not Deleted";

    }


    public ComplaintDto searchComplaint(String complaintId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM complaint WHERE complaint_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,complaintId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            ComplaintDto complaintDto = new ComplaintDto(resultSet.getString("complaint_id"),resultSet.getString("user_id"),resultSet.getString("reason"),resultSet.getString("description"),resultSet.getString("compLevel"),resultSet.getString("date"));
            return complaintDto;

        }
        return null;





    }


    public ArrayList<ComplaintDto> getAllComplaint(String complaintId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM complaint ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ArrayList<ComplaintDto> complaintDtos = new ArrayList<>();


        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            ComplaintDto complaintDto = new ComplaintDto(resultSet.getString("complaint_id"),resultSet.getString("user_id"),resultSet.getString("reason"),resultSet.getString("description"),resultSet.getString("compLevel"),resultSet.getString("date"));
            complaintDtos.add(complaintDto);

        }
        return complaintDtos;





    }








}
