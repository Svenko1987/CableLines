package data;


import application.Computer;

/**
 * Object Line that represents line on some floor that have some purpose
 */
public class Line {
  private String lineName;
  private String linePurpose;
  private Cable cable;
  private int amount;
  private int floor;


  Computer c=new Computer();

  public Line(String lineName, String linePurpose, Cable cable, int amount, int floor) {

    // logički operator ^ je XOR, || je OR; razlika je što ^ znači "ako je jedno I SAMO JEDNO od ovog true", a || znači "ako je bilo šta true"
    if (lineName == null
        || cable == null
        || amount <= 0) {
      throw new IllegalArgumentException("Bad entry");
    }
    else {

      this.lineName = lineName;
      this.linePurpose = linePurpose;
      this.cable = cable;
      this.amount = amount;
      this.floor = floor;
    }
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
