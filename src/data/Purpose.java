package data;


public enum Purpose {
  LIGHTS("Lights"),
  OUTLET("Outlet"),
  FIREALARM("Fire alarm"),
  DATAFLOW("Data flow"),
  VENTILATION("Ventilation"),
  CONNECTION("Connection"),
  POWERSUPLY("Pover suply"),
  VIDEOSURVEILLANCE("Video surveillance");


  private final String name;

  Purpose(String name){
    this.name=name;
  }
  public String getName(){
    return name;
  }



}
