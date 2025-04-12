package lk.sltb.sltbmanagement.dto;

public class MaintenanceDto {
    private String maintenanceId;
    private String date;
    private double  cost;
    private String status;
    private String description;
    private String busId;

    public MaintenanceDto() {}

    public MaintenanceDto(String maintenanceId, String date, double cost, String status, String description, String busId) {
        this.maintenanceId = maintenanceId;
        this.date = date;
        this.cost = cost;
        this.status = status;
        this.description = description;
        this.busId = busId;
    }

    public String getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(String maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    @Override
    public String toString() {
        return "MaintenanceDto{" +
                "maintenanceId='" + maintenanceId + '\'' +
                ", date='" + date + '\'' +
                ", cost=" + cost +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", busId='" + busId + '\'' +
                '}';
    }
}
