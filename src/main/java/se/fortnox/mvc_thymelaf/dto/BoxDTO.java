package se.fortnox.mvc_thymelaf.dto;

public class BoxDTO {
    private String receiverName;
    private int weight;
    private String color;
    private String country;
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BoxDTO(String receiverName, int weight, String color) {
        this.receiverName= receiverName;
        this.weight = weight ;
        this.color= color;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String color) {
        this.color = color;
    }
}