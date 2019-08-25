import application.Computer;
import application.Controller;
import data.Cable;
import data.Line;
import data.Purpose;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SuppressWarnings ({"MessageMissingOnJUnitAssertion", "SpellCheckingInspection", "MagicNumber"})
class ComputerTest {

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
    Cable cable=Cable.FLEXIBLE_3X15;
    Purpose purpose=Purpose.LIGHTS;
    Line line = new Line("32A", purpose,"Hodnik", cable, 2, 1);
    Line line2 = new Line("32A", purpose,"Hodnik", cable, 5, 2);
    computer.addToLines(lines,line);
    lines.add(line2);
    assertEquals(line,computer.selectLine(lines,line));

    Line line3 = new Line("32A", purpose,"Hodnik", cable, 99, 1);
    lines.add(line3);
    assertEquals(1, computer.sumSameFloor(lines, 2));
   // assertEquals(1, computer.sumSameFloor(lines, 2));
    Line line4 = new Line("32A", purpose,"Hodnik", cable, 50, 1);
    lines.add(line4); // todo Svenko1987 : problem 2, dodao sam jedan te isti kabal dva puta, i dva puta ga je računao
    //assertEquals(150, computer.sumSameFloor(lines, 1));


  }

  @Test
  void illegalEntryTest() {
    Cable cable=Cable.FLEXIBLE_3X15;
    Purpose purpose=null;
    Line line5 = new Line("30", purpose,"", cable, -1, 1);
    Exception e = assertThrows(IllegalArgumentException.class, () ->
      lines.add(line5)
    );
    assertEquals("Invalid Lineamount: -1", e.getMessage());


  }



}