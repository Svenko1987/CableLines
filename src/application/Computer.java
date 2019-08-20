package application;

import data.Cable;
import data.Line;

import java.util.Collection;

/**
 * <p>
 * Author: Mirza / mirza.suljic.ba@gmail.com <br>
 * Date: 19.8.2019.
 * </p>
 */

public class Computer implements Controller {


  @Override
  public int sumSameFloor(Collection<Line> lines, int floor) {
    int sum = 0;
    if (lines.isEmpty() == true) {

    }
    else {

      sum = lines.stream().filter(line -> line.getFloor()==floor).map(Line::getAmount).reduce(sum, (a, b) -> a + b);

    }
    return sum;

  }

  @Override
  public void addToCables(Collection<Cable> cables, Cable newCable) {
    cables.add(newCable);

  }
}