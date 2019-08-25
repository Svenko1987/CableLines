package data;


public enum Cable {
  FLEXIBLE_3X15("Flexible", "3x1.5"),
  FLEXIBLE_3X25("Flexible", "3x2.5"),
  FLEXIBLE_3X40("Flexible", "3x4"),
  FLEXIBLE_3X60("Flexible", "3x6"),
  FLEXIBLE_5X15("Flexible", "5x1.5"),
  FLEXIBLE_5X25("Flexible", "5x2.5"),
  FLEXIBLE_5X40("Flexible", "5x4"),
  FLEXIBLE_5X60("Flexible", "5x6"),
  FLEXIBLE_5X10("Flexible", "5x10"),
  COMMUNICATION_CAT4("Comunication", "Cat4"),
  COMMUNICATION_CAT5("Comunication", "Cat5"),
  COMMUNICATION_CAT6("Comunication", "Cat6"),
  COMMUNICATION_CAT7("Comunication", "Cat7"),
  COMMUNICATION_OPTSINGLE("Comunication", "Optical single"),
  COMMUNICATION_OPTSMULTI("Comunication", "Optical Multi");



  private final String name;
  private final String wire;

  Cable(String name, String wire) {
    this.name = name;
    this.wire = wire;
  }

  public String getName() {
    return name;
  }

  public String getWire() {
    return wire;
  }
  }
