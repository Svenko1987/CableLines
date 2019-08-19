import application.Computer;
import application.Controller;
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
    assertEquals(0, c.sumSameFloor(lines)); // todo Sven : sredi metod sumSameFloor da "položi" slučaj kad je list prazna

  }

}