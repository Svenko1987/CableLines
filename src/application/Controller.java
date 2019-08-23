package application;

import data.Cable;
import data.Line;

import java.util.Collection;

public interface Controller {



  /**
   *Cable manipulation
   */
  boolean isItValidCable(String name, String type);
  void addToCables(Collection <Cable> cables, Cable newCable);
  void selectCable(Collection<Cable> cables, Cable enteredCable);
  void removeCable(Collection<Cable> cables, Cable selectedCable);
  void updateCable(Collection<Cable> cables, Cable updatedCable);


  /**
   *Line manipulation
   */
  boolean isItValidLine(String lineName, Cable cable, int amount,int floor);
  void addToLines(Collection<Line> lines, Line line);
  Line selectLine(Collection<Line> lines, Line enteredLine);
  void removeLine(Collection<Line> lines, Line selectedLine);
  void updateLine(Collection<Line> lines, Line selectedLine, Line updatedLine);

  /**
   *
   * Getting summs of wanted type
   */
  int sumSameFloor(Collection<Line> lines,int floor);
  int sumSameCable(Collection<Line> lines, Cable cable);
  int sumAllBuilding(Collection<Line> lines);




}
