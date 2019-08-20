import application.Computer;
import application.Controller;
import data.Cable;
import data.Line;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p>
 * Author: Mirza / mirza.suljic.ba@gmail.com <br>
 * Date: 19.8.2019.
 * </p>
 */
@SuppressWarnings ("MessageMissingOnJUnitAssertion")
class ComputerTest {

  private final Controller c = new Computer();
  private final List<Line> lines = new ArrayList<>();

  @Test
  void sumSameFloorTest() {
    Cable cable=new Cable("E90","3x2.5");
    Line line=new Line("linija1", cable,1,1);
    Line line2=new Line("linija1", cable,1,2);
    lines.add(line);
    lines.add(line2);
    assertEquals(1, c.sumSameFloor(lines,1)); // todo Svden : sredi metosumSameFloor da "položi" slučaj kad je list prazna

  }

}