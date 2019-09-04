package data;


import application.Computer;

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
   * @param lineName    ovo možda ostaviti i opcionalno kao @Nullable
   * @param linePurpose ovo kao enum ti olakšava život jer ne radiš sa stringovima nego sa jednim stringom kojeg niko ne može dirati
   * @param cable       još jedna prednost enuma je što možeš u enumu da čuvaš nepromjenjive, a možeš pozvati i "daj sve ovog tipa što postoji", to će olakšati GUI
   * @param amount
   * @param floor
   */
  public Line(String lineName, Purpose linePurpose, String lineNote, Cable cable, int amount, int floor) throws IllegalArgumentException {

      this.lineName = lineName;
      this.linePurpose = linePurpose;
      this.lineNote = lineNote;
      this.cable = cable;
      this.amount = amount;
      this.floor = floor;

    /*
    * Fora kako da svaki line koji napraviš automatski dodaš u listu.
    *
    * */
    if (this.isValid()) {
      Computer.getAllLines().add(this);
    }
    else {
      throw new IllegalArgumentException();
    }
  }

  private boolean isValid() {
    return amount > -1;
  }


/*
  @Override
  public boolean equals(Object obj) {
    // todo Svenko1987 : ovdje TI definiši kad su dvije linije jednake
    if (obj == null) return false;

    if (obj instanceof Line) {
      Line other = (Line) obj;
      // sad radiš sa other
      return false;
    } else {
      return false;
    }
  }
*/

  public Purpose getLinePurpose() {
    return linePurpose;
  }
  @Override
  public boolean equals(Object obj) {
    // todo Svenko1987 : ovdje TI definiši kad su dvije linije jednake
    if (obj == null) return false;

    if (obj instanceof Line) {
      Line other = (Line) obj;
      // sad radiš sa other
      return false;
    } else {
      return false;
    }
  }

  public void setPurpose(Purpose linePurpose) {
    this.linePurpose = linePurpose;
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
