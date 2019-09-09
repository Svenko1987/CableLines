package application;

import data.Cable;
import data.Line;


import java.io.*;
import java.util.ArrayList;
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
    return !(lineName == null || cable.equals(null) || amount < 0);
  }

  public int seeLine(Collection<Line> lines, Line line) {
    return line.getAmount();
  }

  @Override
  public void addToLines(Collection<Line> lines, Line line) {
    if (!isItValidLine(line.getLineName(), line.getCable(), line.getAmount())) {
      throw new IllegalArgumentException("Invalid line");
    }

    else if (lines.stream().anyMatch(line1 -> line1.getLineName().equals(line.getLineName()))
        && lines.stream().anyMatch(line1 -> line1.getFloor() == line.getFloor())) {

      lines.stream()
          .filter(line1 -> line1.getLineName().equals(line.getLineName()) && line1.getFloor() == line.getFloor())
          .findAny()
          .ifPresent(line1 -> line1.setAmount(line1.getAmount()+line.getAmount()));

      System.out.println("dodano na postojecu " + line.getLineName() + " iznos :" + selectLine(lines, line).getAmount());
    }
    else
      lines.add(line);
    System.out.println("added to lines");
  }

  public void trow() {
    throw new IllegalArgumentException("Text");
  }


  @Override
  public Line selectLine(Collection<Line> lines, Line enteredLine) {

    return lines.stream().filter(line -> line.getLineName().equals(enteredLine.getLineName()) && line.getFloor() == enteredLine.getFloor()).findAny().orElse(null);
  }


  @Override
  public void removeLine(Collection<Line> lines, Line selectedLine) {
    lines.stream().filter(line -> line.equals(selectedLine)).findFirst().ifPresent(line -> lines.remove(line));
  }

  @Override
  public void updateLine(Collection<Line> lines, Line selectedline, Line updatedLine) {
    if (isItValidLine(updatedLine.getLineName(), updatedLine.getCable(), updatedLine.getAmount())) {

      lines.stream().filter(line -> line.getLineName().equals(selectedline.getLineName()) && line.getFloor() == selectedline.getFloor()).findAny()
          .ifPresent(line -> {
            line.setAmount(updatedLine.getAmount());
            line.setLineName(updatedLine.getLineName());
            line.setCable(updatedLine.getCable());
            line.setFloor(updatedLine.getFloor());
            line.setPurpose(updatedLine.getLinePurpose());

          });

    }
    else
      System.out.println("invalid line");
  }

  @Override
  public void saveLines(Collection<Line> lines, String location) {
    try {
      FileOutputStream fos = new FileOutputStream(location);
      ObjectOutputStream oos= new ObjectOutputStream(fos);
      oos.writeObject(lines);
      oos.close();
      fos.close();
      System.out.println("Saved to "+location);
    }catch (IOException i) {
      i.printStackTrace();
    }
  }

  @Override
  public Collection<Line> loadLines(String location) {
    Collection<Line> lines=new ArrayList<>();
    try {
      FileInputStream fis= new FileInputStream(location);
      ObjectInputStream ois= new ObjectInputStream(fis);
      lines= (Collection<Line>) ois.readObject();
      ois.close();
      fis.close();
      System.out.println("Loaded from "+location);

    }catch (IOException i){
      i.printStackTrace();

    }catch (ClassNotFoundException c){
      c.printStackTrace();

    }
      return lines;


  }

  /**
   * Getting sums of wanted type
   */

  @Override
  public int sumSameFloor(Collection<Line> lines, int floor) {
    if (lines.isEmpty() || lines.stream().noneMatch(line -> line.getFloor() != floor)) return 0;
    int sum = 0;
    if (lines.isEmpty()) {
      new IllegalArgumentException("No entries");
    }
    else {
      sum = lines.stream()
          .filter(line -> line.getFloor() == floor)
          .map(Line::getAmount)
          .reduce(sum, (a, b) -> a + b);

    }
    return sum;
  }

  @Override
  public int sumSameCable(Collection<Line> lines, Cable cable) {
    int sum = 0;
    if (lines.isEmpty()) {
      throw new IllegalArgumentException("No entries");
    }
    else {
      sum = lines.stream()
          .filter(line -> line.getCable().equals(cable))
          .map(Line::getAmount)
          .reduce(sum, (a, b) -> a + b);
    }
    return sum;
  }

  @Override
  public int sumAllBuilding(Collection<Line> lines) {
    int sum = 0;
    if (lines.isEmpty()) {
      throw new IllegalArgumentException("No entries");
    }
    else {
      sum = lines.stream().map(Line::getAmount).reduce(sum, (a, b) -> a + b);
    }
    return sum;

  }
}


