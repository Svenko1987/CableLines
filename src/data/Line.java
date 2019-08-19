package data;
/**
* ovdje javadoc: šta je ova klasa i zašto postoji
*/
public class Line {
    private String lineName;
    private String linePurpose;
    private Cable cable;
    private int amount;
    private int floor;

    public Line(String lineName, Cable cable, int amount, int floor) {
        this.lineName = lineName;
        this.cable = cable;
        this.amount = amount;
        this.floor = floor;
    }

    public void setLinePurpose(String linePurpose) {
        this.linePurpose = linePurpose;
    }

    public String getLinePurpose() {
        return linePurpose;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public Cable getCable() {
        return cable;
    }

    public void setCable(Cable cable) {
        this.cable = cable;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
