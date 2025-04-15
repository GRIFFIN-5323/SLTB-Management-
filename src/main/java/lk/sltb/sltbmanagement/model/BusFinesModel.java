package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.BusDto;

import java.sql.Connection;
import java.sql.SQLException;

public class BusFinesModel {


    public void addBusFine(BusDto busDto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();


    }





}
