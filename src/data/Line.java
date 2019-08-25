package data;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Object Line that represents line on some floor that have some purpose
 */
public class Line {
  private String lineName;
  private Purpose linePurpose;
  private String lineNote;
  private Cable cable;
  private int amount;
  private int floor;




  /**
   * @param lineName ovo možda ostaviti i opcionalno kao @Nullable
   * @param purpose  ovo kao enum ti olakšava život jer ne radiš sa stringovima nego sa jednim stringom kojeg niko ne može dirati
   * @param type     još jedna prednost enuma je što možeš u enumu da čuvaš nepromjenjive, a možeš pozvati i "daj sve ovog tipa što postoji", to će olakšati GUI
   * @param amount
   * @param floor
   */
  public Line(String lineName, Purpose purpose, @Nullable String lineNote, @NotNull Cable type, int amount, int floor) {
    if (amount <= 0) throw new IllegalArgumentException("Invalid ");
    this.lineName = lineName;
    this.linePurpose = purpose;
    this.lineNote=lineNote;
    this.cable = type;
    this.floor = floor;
  }



  public String getLinePurpose() {
    return linePurpose.getName();
  }
  public void setPurpose(Purpose linePurpose){
    this.linePurpose=linePurpose;
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
