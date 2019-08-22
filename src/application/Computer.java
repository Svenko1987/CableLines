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
  public boolean isItValidCable( String name, String type) {
    return !(name == null ^ type == null);

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
    throw new UnsupportedOperationException("snh - not implemented yet: removeCable");
  }

  @Override
  public void updateCable(Collection<Cable> cables, Cable updatedCable) {
    throw new UnsupportedOperationException("snh - not implemented yet: updateCable");
  }


  /**
   * Line manipulation
   */
  @Override
  public void isItValidLine(Line line) {
    throw new UnsupportedOperationException("snh - not implemented yet: isItValidLine");
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
  public void selectLine(Collection<Line> lines, Line selectedLine) {
    throw new UnsupportedOperationException("snh - not implemented yet: selectLine");
  }

  @Override
  public void removeLine(Collection<Line> lines, Line selectedLine) {
    throw new UnsupportedOperationException("snh - not implemented yet: removeLine");
  }

  @Override
  public void updateLine(Collection<Line> lines, Line updatedLine) {
    throw new UnsupportedOperationException("snh - not implemented yet: updateLine");
  }  @Override
  public int sumSameFloor(Collection<Line> lines, int floor) {
    // todo Svenko1987 : ovaj metod možeš pojednostaviti ovako
    // Ako je kolekcija prazna ili je zadat sprat na kojem nema kablova, vrati 0;
    if (lines.isEmpty() || lines.stream().noneMatch(line -> line.getFloor() != floor)) return 0;


    int sum = 0;
    if (lines.isEmpty() == true) {
    }
    else {
      sum = lines.stream().filter(line -> line.getFloor() == floor).map(Line::getAmount).reduce(sum, (a, b) -> a + b);
    }
    return sum;
  }
}


