package application;

import data.Cable;
import data.Line;

import java.util.Collection;

public interface Controller {






  /**
   *Line manipulation
   */
  boolean isItValidLine(String lineName, Cable cable, int amount);

  void addToLines(Collection<Line> lines, Line line);
  Line selectLine(Collection<Line> lines, Line enteredLine);
  void removeLine(Collection<Line> lines, Line selectedLine);
  void updateLine(Collection<Line> lines, Line selectedLine, Line updatedLine);

  /**
   *
   * Getting sums of wanted type and sums off all
   *
   *
   */
  int sumSameFloor(Collection<Line> lines,int floor);
  int sumSameCable(Collection<Line> lines, Cable cable);
  int sumAllBuilding(Collection<Line> lines);




}
