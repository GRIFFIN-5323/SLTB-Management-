package lk.sltb.sltbmanagement.dto;

public class EmpViolationDto {
    private String emp_violation_id;
    private String date;
    private String description;
    private double fineAmount;
    private String empId;
    private String violationId;

   public EmpViolationDto() {}

    public EmpViolationDto(String emp_violation_id, String date, String description, double fineAmount, String empId, String violationId) {
        this.emp_violation_id = emp_violation_id;
        this.date = date;
        this.description = description;
        this.fineAmount = fineAmount;
        this.empId = empId;
        this.violationId = violationId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmp_violation_id() {
        return emp_violation_id;
    }

    public void setEmp_violation_id(String emp_violation_id) {
        this.emp_violation_id = emp_violation_id;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getViolationId() {
        return violationId;
    }

    public void setViolationId(String violationId) {
        this.violationId = violationId;
    }

    @Override
    public String toString() {
        return "EmpViolationDto{" +
                "emp_violation_id='" + emp_violation_id + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", fineAmount=" + fineAmount +
                ", empId='" + empId + '\'' +
                ", violationId='" + violationId + '\'' +
                '}';
    }
}
