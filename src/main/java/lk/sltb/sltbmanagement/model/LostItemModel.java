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



    public String getNextLostId() throws SQLException, ClassNotFoundException {
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT item_id from Lost_Item ORDER BY item_id DESC LIMIT 1");

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            String lastId=resultSet.getString(1);
            String lastIdNumberString=lastId.substring(1) ;
            int lastIdNumber=Integer.parseInt(lastIdNumberString);
            int nextIdNumber=lastIdNumber+1;

            String nextIdString=String.format("L%03d",nextIdNumber);
            return nextIdString;
        }

        return "L001";





    }

  public String saveLostItem(LostItemDto lostItemDto) throws SQLException, ClassNotFoundException {
      Connection connection= DBConnection.getInstance().getConnection();


      try{
          connection.setAutoCommit(false);
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

      String empId=lostItemDto.getEmpId();


      boolean saveLostItem= preparedStatement.executeUpdate()>0 ;

      if (saveLostItem) {
          String pointSql = "UPDATE Employee SET emp_point=(emp_point+1) WHERE emp_id=? ";
          boolean addPoint = true;


              PreparedStatement pointStmt = connection.prepareStatement(pointSql);
              pointStmt.setString(1,empId);

          System.out.println(pointSql);
              if (!(pointStmt.executeUpdate() > 0)) {
                  addPoint = false;
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
          return "Fail";
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
