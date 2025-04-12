package lk.sltb.sltbmanagement.dto;

public class ViolationDto {

    private String violation_id;
    private String description;
    private String type;

    public ViolationDto(){}

    public ViolationDto(String violation_id, String description, String type) {
        this.violation_id = violation_id;
        this.description = description;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getViolation_id() {
        return violation_id;
    }

    public void setViolation_id(String violation_id) {
        this.violation_id = violation_id;
    }

    @Override
    public String toString() {
        return "ViolationDto{" +
                "violation_id='" + violation_id + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
