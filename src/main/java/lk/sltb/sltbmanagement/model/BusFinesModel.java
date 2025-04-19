package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.BusDto;
import lk.sltb.sltbmanagement.dto.ScheduleDto;
import lk.sltb.sltbmanagement.dto.TimetableDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BusFinesModel {


    public void addBusFine(BusDto busDto, ArrayList<TimetableDto>timetableDtos, ArrayList<ScheduleDto> scheduleDtos) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();


        LocalTime time = LocalTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeString = time.format(timeFormat);

        for (TimetableDto timetableDto : timetableDtos) {





        }





    }





}
