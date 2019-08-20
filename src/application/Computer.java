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

@SuppressWarnings ("SpellCheckingInspection")
public class Computer implements Controller {


  @Override
  public int sumSameFloor(Collection<Line> lines, int floor) {
    // todo Svenko1987 : ovaj metod možeš pojednostaviti ovako
    // Ako je kolekcija prazna ili je zadat sprat na kojem nema kablova, vrati 0;
    if (lines.isEmpty() || lines.stream().noneMatch(line -> line.getFloor() != floor)) return 0;


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