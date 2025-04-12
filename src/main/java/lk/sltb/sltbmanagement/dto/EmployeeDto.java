package lk.sltb.sltbmanagement.dto;

public class EmployeeDto {

    private String emp_id;
    private String name;
    private String email;
    private String contact;
    private int emp_point;
    private String role;
    private String address;

    public EmployeeDto() {};

    public EmployeeDto(String emp_id, String name, String email, String contact, int emp_point, String role, String address) {
        this.emp_id = emp_id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.emp_point = emp_point;
        this.role = role;
        this.address = address;

    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getEmp_point() {
        return emp_point;
    }

    public void setEmp_point(int emp_point) {
        this.emp_point = emp_point;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "emp_id='" + emp_id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", emp_point=" + emp_point +
                ", role='" + role + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
