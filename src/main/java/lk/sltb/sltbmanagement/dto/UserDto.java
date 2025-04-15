package lk.sltb.sltbmanagement.dto;

public class UserDto {
    private String user_id;
    private String name;
    private String address;
    private String role;
    private String email;
    private String contact;
    private String password;

    public UserDto() {
    }

    public UserDto(String user_id, String name, String address, String role, String email, String password, String contact) {
        this.user_id = user_id;
        this.name = name;
        this.address = address;
        this.role = role;
        this.email = email;
        this.password = password;
        this.contact = contact;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "user_id='" + user_id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
