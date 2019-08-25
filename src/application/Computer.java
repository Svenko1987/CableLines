package application;

import data.Cable;
import data.Line;

import java.util.Collection;

/**
 * Class for methods that use Line and Cable objects
 */


public class Computer implements Controller {


  /**
   * Line manipulation
   */



  @Override
  public boolean isItValidLine(String lineName, Cable cable, int amount) {
    return !(lineName==null || cable.equals(null) || amount<=0);
  }

  @Override
  public void addToLines(Collection<Line> lines, Line line) {

    if (lines.stream().anyMatch(line1 -> line1.getLineName().equals(line.getLineName()))) {
      lines.stream().filter(line1 -> line1.getLineName().equals(line.getLineName()) && line1.getFloor() == line.getFloor()).map(Line::getAmount).reduce((a, b) -> a + b);

    }
    else
      lines.add(line);
  }


  @Override
  public Line selectLine(Collection<Line> lines, Line enteredLine) {

    return lines.stream().filter(line -> line.equals(enteredLine)).findAny().orElse(null);
  }


  @Override
  public void removeLine(Collection<Line> lines, Line selectedLine) {
    lines.stream().filter(line -> line.equals(selectedLine)).findFirst().ifPresent(line -> lines.remove(line));
  }

  @Override
  public void updateLine(Collection<Line> lines, Line selectedline, Line updatedLine) {
    if (isItValidLine(updatedLine.getLineName(),updatedLine.getCable(), updatedLine.getAmount())) {
      lines.stream().filter(line -> line.equals(selectedline)).findAny().ifPresent(line -> line = updatedLine);
    }
  }

  /**
   * Getting sums of wanted type
   */

  @Override
  public int sumSameFloor(Collection<Line> lines, int floor) {
    if (lines.isEmpty() || lines.stream().noneMatch(line -> line.getFloor() != floor)) return 0;
    int sum = 0;
    if (lines.isEmpty() == true) {
      new IllegalArgumentException("No entries");
    }
    else {
      sum = lines.stream().filter(line -> line.getFloor()==floor).map(Line::getAmount).reduce(sum, (a, b) -> a + b);
      System.out.println("Sabralo"+sum+ lines.toString());


    }
    return sum;
  }

  @Override
  public int sumSameCable(Collection<Line> lines,  Cable cable) {
    int sum = 0;
    if (lines.isEmpty() == true) {
      throw new IllegalArgumentException("No entries");
    }
    else {
      sum = lines.stream().filter(line -> line.getCable().equals(cable)).map(Line::getAmount).reduce(sum, (a, b) -> a + b);
    }
    return sum;
  }

  @Override
  public int sumAllBuilding(Collection<Line> lines) {
    int sum = 0;
    if (lines.isEmpty() == true) {
      throw new IllegalArgumentException("No entries");
    }
    else {
      sum = lines.stream().map(Line::getAmount).reduce(sum, (a, b) -> a + b);
    }
    return sum;

  }
}


