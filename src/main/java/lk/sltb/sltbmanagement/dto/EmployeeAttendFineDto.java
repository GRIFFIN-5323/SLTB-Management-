package lk.sltb.sltbmanagement.dto;

public class EmployeeAttendFineDto {
    private String empFineId;
    private String reason;
    private int lateMinute;
    private double amount;
    private String date;
    private String attendId;

    public EmployeeAttendFineDto() {}

    public EmployeeAttendFineDto(String empFineId, String reason, int lateMinute, double amount, String date, String attendId) {
        this.empFineId = empFineId;
        this.reason = reason;
        this.lateMinute = lateMinute;
        this.amount = amount;
        this.date = date;
        this.attendId = attendId;
    }

    public String getEmpFineId() {
        return empFineId;
    }

    public void setEmpFineId(String empFineId) {
        this.empFineId = empFineId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getLateMinute() {
        return lateMinute;
    }

    public void setLateMinute(int lateMinute) {
        this.lateMinute = lateMinute;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAttendId() {
        return attendId;
    }

    public void setAttendId(String attendId) {
        this.attendId = attendId;
    }

    @Override
    public String toString() {
        return "EmployeeAttendFineDto{" +
                "empFineId='" + empFineId + '\'' +
                ", reason='" + reason + '\'' +
                ", lateMinute=" + lateMinute +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", attendId='" + attendId + '\'' +
                '}';
    }
}
