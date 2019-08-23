package data;

/**
 * <p>
 * Author: Mirza S. / mirza.suljic.ba@gmail.com <br>
 * Date: 23.8.2019.
 * </p>
 */
public enum CableType {
  TYPE_3X15("3x1,5"),
  TYPE_3X25("3x2,5"),
  TYPE_5x25("5x2,5"),
  TYPE_CAT8("CAT 8");

  private final String name;
  CableType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
