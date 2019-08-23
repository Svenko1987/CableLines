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
  void selectCable(Collection<Cable> cables, Cable selectedCable);
  void removeCable(Collection<Cable> cables, Cable selectedCable);
  void updateCable(Collection<Cable> cables, Cable updatedCable);

  /**
   *Line manipulation
   */
  void isItValidLine(Line line);
  void addToLines(Collection<Line> lines, Line line);
  void selectLine(Collection<Line> lines, Line selectedLine);
  void removeLine(Collection<Line> lines, Line selectedLine);
  void updateLine(Collection<Line> lines, Line updatedLine);
  int sumSameFloor(Collection<Line> lines,int floor);



}
