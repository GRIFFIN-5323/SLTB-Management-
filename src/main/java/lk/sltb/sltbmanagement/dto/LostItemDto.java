package lk.sltb.sltbmanagement.dto;

public class LostItemDto {

    private String itemId;
    private String itemType;
    private String description;
    private String reportedBy;
    private String locationFound;
    private String timeFound;
    private String dateFound;
    private String empId;

    public LostItemDto() {}

    public LostItemDto(String itemId, String itemType, String description, String reportedBy, String locationFound, String timeFound, String dateFound, String empId) {
        this.itemId = itemId;
        this.itemType = itemType;
        this.description = description;
        this.reportedBy = reportedBy;
        this.locationFound = locationFound;
        this.timeFound = timeFound;
        this.dateFound = dateFound;
        this.empId = empId;
    }


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocationFound() {
        return locationFound;
    }

    public void setLocationFound(String locationFound) {
        this.locationFound = locationFound;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public String getTimeFound() {
        return timeFound;
    }

    public void setTimeFound(String timeFound) {
        this.timeFound = timeFound;
    }

    public String getDateFound() {
        return dateFound;
    }

    public void setDateFound(String dateFound) {
        this.dateFound = dateFound;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "LostItemDto{" +
                "itemId='" + itemId + '\'' +
                ", itemType='" + itemType + '\'' +
                ", description='" + description + '\'' +
                ", reportedBy='" + reportedBy + '\'' +
                ", locationFound='" + locationFound + '\'' +
                ", timeFound='" + timeFound + '\'' +
                ", dateFound='" + dateFound + '\'' +
                ", empId='" + empId + '\'' +
                '}';
    }
}
