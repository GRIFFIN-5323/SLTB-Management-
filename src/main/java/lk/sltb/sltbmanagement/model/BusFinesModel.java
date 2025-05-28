package lk.sltb.sltbmanagement.model;

import lk.sltb.sltbmanagement.DBConnection.DBConnection;
import lk.sltb.sltbmanagement.dto.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BusFinesModel {


    public String addBusFine(BusFinesDto busFinesDto, ArrayList<TimetableDto> timetableDtos, ArrayList<ScheduleDto> scheduleDtos,ArrayList<EmployeeDto> employeeDtos) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();



try {

    connection.setAutoCommit(false);


    String sql="INSERT INTO VALUES (?,?,?,?,?)";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);

    preparedStatement.setString(1, busFinesDto.getBusFineId());


    LocalTime time = LocalTime.now();
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String date = dateFormat.format(dateTime);
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
    String timeString = time.format(timeFormat);



    for(TimetableDto timetableDto : timetableDtos){
        for(ScheduleDto scheduleDto : scheduleDtos){
            if(timetableDto.getRouteId().equals(scheduleDto.getRouteId())){

                LocalDateTime timeTableArrival = LocalDateTime.parse(timetableDto.getArrivalTime(), timeFormat);
                LocalDateTime timeTableDeparture = LocalDateTime.parse(timetableDto.getDepartureTime(), timeFormat);

                LocalDateTime scheduleArrival = LocalDateTime.parse(scheduleDto.getArrivalTime(), timeFormat);
                LocalDateTime scheduleDeparture = LocalDateTime.parse(scheduleDto.getDepartureTime(), timeFormat);


                Duration durationArrival = Duration.between(timeTableArrival, scheduleArrival);
                Duration durationDeparture = Duration.between(timeTableDeparture, scheduleDeparture);

                double arrival = durationArrival.toMinutes();
                double departure = durationDeparture.toMinutes() ;
                double totalLate= arrival+departure;

                if(arrival>0){
                    preparedStatement.setDouble(2,arrival) ;


                }

                else if(departure>0){
                    preparedStatement.setDouble(3,departure) ;
                }

                else{
                    preparedStatement.setDouble(2,0) ;
                    preparedStatement.setDouble(3,0) ;

                }


                preparedStatement.setDouble(3,totalLate);

                double totelFine=totalLate*2;
                preparedStatement.setDouble(4,totelFine);
                preparedStatement.setString(5,date);
                preparedStatement.setString(6,busFinesDto.getBusId());


                boolean success = preparedStatement.executeUpdate()>0;

                if(success) {

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
                    }

                }else{
                    connection.rollback();
                    return "Fail to Add Bus_Violation";



                }









            }
        }
    }




}
catch (Exception e) {
    connection.rollback();


    throw e;

}finally {
    connection.setAutoCommit(true);



}












return "Success";
    }
}