package lk.sltb.sltbmanagement.dto;

public class ComplaintDto {
    private String complaint_id;
    private String user_id;
    private String reason;
    private String description;
    private String compLevel;
    private String date;

  public ComplaintDto() {

  }

    public ComplaintDto(String complaint_id, String user_id, String reason, String description, String compLevel, String date) {
        this.complaint_id = complaint_id;
        this.user_id = user_id;
        this.reason = reason;
        this.description = description;
        this.compLevel = compLevel;
        this.date = date;
    }




    public String getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(String complaint_id) {
        this.complaint_id = complaint_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompLevel() {
        return compLevel;
    }

    public void setCompLevel(String compLevel) {
        this.compLevel = compLevel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ComplaintDto{" +
                "complaint_id='" + complaint_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", reason='" + reason + '\'' +
                ", description='" + description + '\'' +
                ", compLevel='" + compLevel + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
