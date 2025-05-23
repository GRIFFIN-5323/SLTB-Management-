package lk.sltb.sltbmanagement.dto;

public class AttendanceDto {
    private String attendId;
    private String status;
    private String date;
    private String time;
    private String empId;



    public AttendanceDto() {}

    public AttendanceDto(String attendId, String status, String date, String time, String empId) {
        this.attendId = attendId;
        this.status = status;
        this.date = date;
        this.time = time;
        this.empId = empId;
    }


    public String getAttendId() {
        return attendId;
    }

    public void setAttendId(String attendId) {
        this.attendId = attendId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }


    @Override
    public String toString() {
        return "AttendanceDto{" +
                "attendId='" + attendId + '\'' +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", empId='" + empId + '\'' +
                '}';
    }
}
