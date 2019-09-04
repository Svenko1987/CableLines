package data;


public enum Purpose {
  LIGHTS("Lights"),
  OUTLET("Outlet"),
  FIREALARM("Fire alarm"),
  DATAFLOW("Data flow"),
  VENTILATION("Ventilation"),
  CONNECTION("Connection"),
  POWERSUPPLY("Power supply"),
  VIDEO_SURVEILLANCE("Video surveillance"); // todo Svenko1987: po konvenciji, enume tretiraš kao public static, znači velikim slovima i sa _ između riječi


  private final String name;

  Purpose(String name){
    this.name=name;
  }
  public String getName(){
    return name;
  }



}
