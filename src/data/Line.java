package data;


import application.Computer;
import org.jetbrains.annotations.NotNull;

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

  /**
   * @param lineName ovo možda ostaviti i opcionalno kao @Nullable
   * @param purpose ovo kao enum ti olakšava život jer ne radiš sa stringovima nego sa jednim stringom kojeg niko ne može dirati
   * @param type    još jedna prednost enuma je što možeš u enumu da čuvaš nepromjenjive, a možeš pozvati i "daj sve ovog tipa što postoji", to će olakšati GUI
   * @param amount
   * @param floor
   */
  public Line(String lineName, Purpose purpose, @NotNull CableType type, int amount, int floor) {
    if (amount < 0) throw new IllegalArgumentException("Invalid " + this.getClass().getSimpleName() + "amount: " + amount);
    this.lineName = lineName;
    this.linePurpose = purpose.name();
    this.cable = new Cable(type.getName(), type.getName());
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
