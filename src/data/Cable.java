package data;


import application.Computer;

/**
 * Object cable represents type of cable that is used
 */

public class Cable {
  private final String name;
  private final String type;

  Computer c=new Computer();

  public Cable(String name, String type) {
    if (name == null ^ type == null){
      throw new IllegalArgumentException("Bad entry");
    }
    else{
          this.name = name;
          this.type = type;
      }
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }
}
