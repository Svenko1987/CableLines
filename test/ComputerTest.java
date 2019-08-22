import application.Computer;
import application.Controller;
import data.Cable;
import data.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p>
 * Author: Mirza / mirza.suljic.ba@gmail.com <br>
 * Date: 19.8.2019.
 * </p>
 */
@SuppressWarnings ({"MessageMissingOnJUnitAssertion", "SpellCheckingInspection", "MagicNumber"})
class ComputerTest {
  private final Cable cable = new Cable("E90","3x2.5");
  private Controller computer;
  private List<Line> lines;

  /**
   * Ovaj metod ima anotaciju BeforeEach; znači ovaj metod se izvodi jednom prije svakog testa.
   * Odnosno, imaćemo novi Computer i ArrayList prije svakog testa.
   */
  @BeforeEach
  void prepare() {
    computer = new Computer();
    lines = new ArrayList<>();
  }

  @Test
  void sumSameFloorTest() {
    Cable cable=new Cable("E90","3x2.5");
    Line line=new Line("linija1", "rasvjeta",cable,1,1);
    Line line2=new Line("linija1", "rasvjeta",cable,1,2);
    lines.add(line);
    lines.add(line2);
    assertEquals(1, computer.sumSameFloor(lines,1));
    Line line3 = new Line("linija1", "rasvjeta",cable, 99, 1);
    lines.add(line3);
    assertEquals(100, computer.sumSameFloor(lines,1));
    assertEquals(1, computer.sumSameFloor(lines,2));
    Line line4 = new Line("linija1", "rasvjeta",cable, 50, 1);
    lines.add(line4); // todo Svenko1987 : problem 2, dodao sam jedan te isti kabal dva puta, i dva puta ga je računao
    assertEquals(150, computer.sumSameFloor(lines,1));

    // lines.add(new Line("invalid", "rasvjeta", cable, -1000, 1));
    // todo Svenko1987 : problem 3, kabal negativne dužine
    // assertThrows(IllegalArgumentException.class,() ->{Sta ide ovdje} );

  }

  @SuppressWarnings ("UnsecureRandomNumberGeneration")
  @Test
  void aMillionCables() {
    Random r = new Random();
    for (int i = 0; i < 1000000; i++) {
      lines.add(new Line("Line" + i,"rasvjeta", cable, r.nextInt(100)+1, r.nextInt(10)));
    }
    assertEquals(1000000, lines.size());
  }

}