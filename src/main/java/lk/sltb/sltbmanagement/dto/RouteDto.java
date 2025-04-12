package lk.sltb.sltbmanagement.dto;

public class RouteDto {

    private String routeId;
    private String routeNum;
    private double fuelConsumption;
    private int halts;
    private String duration;
    private double distance;
    private String departureLocation;
    private String arrivalLocation;
    private String timetableId;


    public RouteDto() {}

    public RouteDto(double fuelConsumption, String routeNum, String routeId, int halts, String duration, double distance, String departureLocation, String arrivalLocation, String timetableId) {
        this.fuelConsumption = fuelConsumption;
        this.routeNum = routeNum;
        this.routeId = routeId;
        this.halts = halts;
        this.duration = duration;
        this.distance = distance;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.timetableId = timetableId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getRouteNum() {
        return routeNum;
    }

    public void setRouteNum(String routeNum) {
        this.routeNum = routeNum;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getHalts() {
        return halts;
    }

    public void setHalts(int halts) {
        this.halts = halts;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
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

    public String getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(String timetableId) {
        this.timetableId = timetableId;
    }

    @Override
    public String toString() {
        return "RouteDto{" +
                "routeId='" + routeId + '\'' +
                ", routeNum='" + routeNum + '\'' +
                ", fuelConsumption=" + fuelConsumption +
                ", halts=" + halts +
                ", duration='" + duration + '\'' +
                ", distance=" + distance +
                ", departureLocation='" + departureLocation + '\'' +
                ", arrivalLocation='" + arrivalLocation + '\'' +
                ", timetableId='" + timetableId + '\'' +
                '}';
    }
}
