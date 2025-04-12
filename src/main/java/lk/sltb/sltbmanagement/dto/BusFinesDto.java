package lk.sltb.sltbmanagement.dto;

public class BusFinesDto {
    private String  busFineId ;
    private String lateDuration;
    private double amount;
    private String date;
    private String busId;

    public BusFinesDto(){}

    public BusFinesDto(String busFineId, String lateDuration, String date, String busId, double amount) {
        this.busFineId = busFineId;
        this.lateDuration = lateDuration;
        this.date = date;
        this.busId = busId;
        this.amount = amount;
    }

    public String getBusFineId() {
        return busFineId;
    }

    public void setBusFineId(String busFineId) {
        this.busFineId = busFineId;
    }

    public String getLateDuration() {
        return lateDuration;
    }

    public void setLateDuration(String lateDuration) {
        this.lateDuration = lateDuration;
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

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    @Override
    public String toString() {
        return "BusFinesDto{" +
                "busFineId='" + busFineId + '\'' +
                ", lateDuration='" + lateDuration + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", busId='" + busId + '\'' +
                '}';
    }
}
