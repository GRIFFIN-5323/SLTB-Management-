package lk.sltb.sltbmanagement.dto;

public class EmergencyDto {

    private String incidentId;
    private String date;
    private String location;
    private String type;
    private String actionTaken;
    private String busId;

    public EmergencyDto() {}

    public EmergencyDto(String incidentId, String date, String location, String actionTaken, String type, String busId) {
        this.incidentId = incidentId;
        this.date = date;
        this.location = location;
        this.actionTaken = actionTaken;
        this.type = type;
        this.busId = busId;
    }

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    @Override
    public String toString() {
        return "EmergencyDto{" +
                "incidentId='" + incidentId + '\'' +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", actionTaken='" + actionTaken + '\'' +
                ", busId='" + busId + '\'' +
                '}';
    }
}
