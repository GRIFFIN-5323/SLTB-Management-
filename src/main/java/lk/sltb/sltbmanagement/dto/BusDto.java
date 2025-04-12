package lk.sltb.sltbmanagement.dto;

public class BusDto {

    private String busId;
    private String busNumber;
    private int capacity;
    private String model;
    private String type;
    private String status;
    private String routeId;
    private String empId;

    public BusDto() {}

    public BusDto(String busId, String busNumber, int capacity, String model, String type, String status, String routeId, String empId) {
        this.busId = busId;
        this.busNumber = busNumber;
        this.capacity = capacity;
        this.model = model;
        this.type = type;
        this.status = status;
        this.routeId = routeId;
        this.empId = empId;



    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "BusDto{" +
                "busId='" + busId + '\'' +
                ", busNumber='" + busNumber + '\'' +
                ", capacity=" + capacity +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", routeId='" + routeId + '\'' +
                ", empId='" + empId + '\'' +
                '}';
    }
}
