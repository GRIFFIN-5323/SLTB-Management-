package lk.sltb.sltbmanagement.dto;

public class TimetableDto {
    private String timetableId;
    private String departureLocation;
    private String arrivalLocation;
    private String arrivalTime;
    private String departureTime;
    private String routeId;

    public TimetableDto() {
    }

    public TimetableDto(String timetableId, String departureLocation, String arrivalLocation, String arrivalTime, String departureTime, String routeId) {
        this.timetableId = timetableId;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.routeId = routeId;
    }

    public String getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(String timetableId) {
        this.timetableId = timetableId;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "TimetableDto{" +
                "timetableId='" + timetableId + '\'' +
                ", departureLocation='" + departureLocation + '\'' +
                ", arrivalLocation='" + arrivalLocation + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", routeId='" + routeId + '\'' +
                '}';
    }
}
