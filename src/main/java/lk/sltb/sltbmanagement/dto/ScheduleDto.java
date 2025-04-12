package lk.sltb.sltbmanagement.dto;

public class ScheduleDto {
    private String scheduleId;
    private String date;
    private String departureTime;
    private String arrivalTime;
    private String delayReason;
    private String busNum;
    private String driverName;
    private String conductorName;
    private String routeId;

    public ScheduleDto() {}

    public ScheduleDto(String scheduleId, String date, String departureTime, String arrivalTime, String delayReason, String busNum, String driverName, String routeId, String conductorName) {
        this.scheduleId = scheduleId;
        this.date = date;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.delayReason = delayReason;
        this.busNum = busNum;
        this.driverName = driverName;
        this.routeId = routeId;
        this.conductorName = conductorName;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDelayReason() {
        return delayReason;
    }

    public void setDelayReason(String delayReason) {
        this.delayReason = delayReason;
    }

    public String getBusNum() {
        return busNum;
    }

    public void setBusNum(String busNum) {
        this.busNum = busNum;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getConductorName() {
        return conductorName;
    }

    public void setConductorName(String conductorName) {
        this.conductorName = conductorName;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "ScheduleDto{" +
                "scheduleId='" + scheduleId + '\'' +
                ", date='" + date + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", delayReason='" + delayReason + '\'' +
                ", busNum='" + busNum + '\'' +
                ", driverName='" + driverName + '\'' +
                ", conductorName='" + conductorName + '\'' +
                ", routeId='" + routeId + '\'' +
                '}';
    }
}
