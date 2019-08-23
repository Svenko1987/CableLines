package application;

import data.Cable;
import data.Line;

import java.util.Collection;

/**
 * Class for methods that use Line and Cable objects
 */


public class Computer implements Controller {


  /**
   * Cable manipulation
   */
  @Override
  public boolean isItValidCable(String name, String type) {
    return !(name == null || type == null);

  }

  @Override
  public void addToCables(Collection<Cable> cables, Cable newCable) {
    cables.add(newCable);


  }

  @Override
  public void selectCable(Collection<Cable> cables, Cable selectedCable) {
    throw new UnsupportedOperationException("snh - not implemented yet: selectCable");
  }

  @Override
  public void removeCable(Collection<Cable> cables, Cable selectedCable) {
    if (isItValidCable(selectedCable.getName(), selectedCable.getType())) {

    }
  }

  @Override
  public void updateCable(Collection<Cable> cables, Cable updatedCable) {
    throw new UnsupportedOperationException("snh - not implemented yet: updateCable");
  }


  /**
   * Line manipulation
   */
  @Override
  public boolean isItValidLine(String lineName, Cable cable, int amount, int floor) {
    return !(lineName == null || cable == null || amount <= 0);

  }


  @Override
  public void addToLines(Collection<Line> lines, Line line) {

    if (lines.stream().anyMatch(line1 -> line1.getLineName().equals(line.getLineName()))) {
      lines.stream().filter(line1 -> line1.getLineName().equals(line.getLineName())).map(Line::getAmount).reduce((a, b) -> a + b);

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
  public void updateLine(Collection<Line> lines,Line selectedline, Line updatedLine) {
    if (isItValidLine(updatedLine.getLineName(), updatedLine.getCable(), updatedLine.getAmount(), updatedLine.getFloor()))
    lines.stream().filter(line -> line.equals(selectedline)).findAny().ifPresent(line -> line=updatedLine);
  }

  /**
   * Getting sums of wanted type
   */

  @Override
  public int sumSameFloor(Collection<Line> lines, int floor) {
    if (lines.isEmpty() || lines.stream().noneMatch(line -> line.getFloor() != floor)) return 0;
    int sum = 0;
    if (lines.isEmpty() == true) {
    }
    else {
      sum = lines.stream().filter(line -> line.getFloor() == floor).map(Line::getAmount).reduce(sum, (a, b) -> a + b);
    }
    return sum;
  }

  @Override
  public int sumSameCable(Collection<Line> lines, Cable cable) {
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


