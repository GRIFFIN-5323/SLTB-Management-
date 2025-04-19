package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.EmployeeDto;
import lk.sltb.sltbmanagement.dto.LostItemDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LostItemModel {

  public String saveLostItem(LostItemDto lostItemDto, ArrayList<EmployeeDto> employeeDtos) throws SQLException, ClassNotFoundException {
      Connection connection= DBConnection.getInstance().getConnection();

      try{
      String sql="INSERT INTO Lost_Item VALUES (?,?,?,?,?,?,?,?)";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, lostItemDto.getItemId());
      preparedStatement.setString(2, lostItemDto.getItemType());
      preparedStatement.setString(3, lostItemDto.getDescription());
      preparedStatement.setString(4,lostItemDto.getReportedBy());
      preparedStatement.setString(5,lostItemDto.getLocationFound());
      preparedStatement.setString(6,lostItemDto.getTimeFound());
      preparedStatement.setString(7,lostItemDto.getDateFound());
      preparedStatement.setString(8,lostItemDto.getEmpId());


      boolean saveLostItem= preparedStatement.executeUpdate()>0 ;

      if (saveLostItem) {
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
          return "Fail to Add LostItem";
      }

  } catch (SQLException e) {
        connection.rollback();


        throw e;

    } finally {
        connection.setAutoCommit(true);


    }


}
















public String updateLostItem(LostItemDto lostItemDto) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="UPDATE Lost_Item SET item_type=?,description=?,reported_by=?,location_found=?,time_found=?,date_found=? ,emp_id=? WHERE item_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, lostItemDto.getItemType());
        preparedStatement.setString(2, lostItemDto.getDescription());
        preparedStatement.setString(3,lostItemDto.getReportedBy());
        preparedStatement.setString(4,lostItemDto.getLocationFound());
        preparedStatement.setString(5,lostItemDto.getTimeFound());
        preparedStatement.setString(6,lostItemDto.getDateFound());
        preparedStatement.setString(7,lostItemDto.getEmpId());
        preparedStatement.setString(8, lostItemDto.getItemId());


        return preparedStatement.executeUpdate()>0 ? "Successful Updated " : "Failed Update ";







    }

    public String deleteLostItem(String itemId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="DELETE FROM Lost_Item WHERE item_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, itemId);


        return preparedStatement.executeUpdate()>0 ? "Successful Deleted " : "Failed Deleted ";







    }

    public LostItemDto searchLostItem(String itemId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="DELETE FROM Lost_Item WHERE item_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, itemId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            LostItemDto lostItemDto = new LostItemDto(resultSet.getString("item_id"),resultSet.getString("item_type"),resultSet.getString("description"),resultSet.getString("reported_by"),resultSet.getString("location_found"),resultSet.getString("time_found"),resultSet.getString("date_found"),resultSet.getString("emp_id"));
            return lostItemDto;
        }
        return null;










    }

    public ArrayList<LostItemDto> getAllLostItem(String itemId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="DELETE FROM Lost_Item ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);


         ArrayList<LostItemDto> lostItemDtos = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            LostItemDto lostItemDto = new LostItemDto(resultSet.getString("item_id"),resultSet.getString("item_type"),resultSet.getString("description"),resultSet.getString("reported_by"),resultSet.getString("location_found"),resultSet.getString("time_found"),resultSet.getString("date_found"),resultSet.getString("emp_id"));
           lostItemDtos.add(lostItemDto);

        }
        return lostItemDtos;










    }
}
