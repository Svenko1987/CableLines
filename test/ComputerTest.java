import application.Computer;
import application.Controller;
import data.Cable;
import data.Line;
import data.Purpose;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

  @DisplayName("Zajebani test sa sopstvenim nazivom")
  @Test
  void duplicateLinesEqualityTest() {
    Line lineOne = new Line("A", Purpose.VIDEO_SURVEILLANCE, "", Cable.COMMUNICATION_CAT6, 100, -1);
    Line lineTwo = new Line("A", Purpose.VIDEO_SURVEILLANCE, "", Cable.COMMUNICATION_CAT6, 100, -1);

    assertEquals(lineOne, lineTwo, "Identične linije nisu equal.");
  }

  @SuppressWarnings ("ResultOfObjectAllocationIgnored")
  @Test
  void failFastTest() {
    assertThrows(IllegalArgumentException.class, () -> new Line("", Purpose.LIGHTS, "", Cable.FLEXIBLE_3X15, -15, 0));
    new Line("VALID", Purpose.LIGHTS, "", Cable.FLEXIBLE_3X15, 15, 0);
    assertEquals(1, Computer.getAllLines().size());
  }

  @Test
  void sumSameFloorTest() {

    Line line = new Line("32A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 2, 1);
    Line line2 = new Line("37A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 5, 2);
    Line line3 = new Line("14", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 2, 1);
    lines.add(line);
    lines.add(line2);
    lines.add(line3);
    assertEquals(4,computer.sumSameFloor(lines,1));
    // todo Svenko1987 : šta testiramo ovdje? zašto 4 na istom spratu kad su 2 dodata stavi u javadoc
  }
  @Test
  void sumSameLineTest(){
    Line line = new Line("32A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 2, 1);
    Line line2 = new Line("32A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 5, 1);
    computer.addToLines(lines,line);
    computer.addToLines(lines,line2);


    assertEquals(7,computer.selectLine(lines,line).getAmount());


  }
  @Test
  void removeLineTest(){

  }
  @Test
  void summAllBuildingTest(){

    Line line = new Line("32A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 2, 1);
    Line line2 = new Line("37A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 5, 2);
    Line line3 = new Line("14", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 2, 1);
    lines.add(line);
    lines.add(line2);
    lines.add(line3);
    assertEquals(9,computer.sumAllBuilding(lines));
  }
  @Test
  void updateLineTest(){
    Line line = new Line("32A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 2, 1);
    Line line2 = new Line("32A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 5, 1);
    lines.add(line);
    computer.updateLine(lines,line,line2);
    assertEquals(computer.selectLine(lines,line).getAmount(),line2.getAmount());


  }
  @Test
  void summSameCableTest(){
    Line line = new Line("32A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 2, 1);
    Line line2 = new Line("37A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X25, 5, 2);
    Line line3 = new Line("14", Purpose.OUTLET, "Hodnik", Cable.FLEXIBLE_3X15, 5, 3);
    lines.add(line);
    lines.add(line2);
    lines.add(line3);
    assertEquals(7,computer.sumSameCable(lines,Cable.FLEXIBLE_3X15));
  }

  @Test
  void illegalEntryTest() {
    Cable cable = Cable.FLEXIBLE_3X15;
    Purpose purpose = Purpose.LIGHTS;
    Line invalidLine=new Line("a",purpose,"no note",cable,-8,2);


    Exception e = assertThrows(IllegalArgumentException.class, () -> {
      computer.addToLines(lines,invalidLine);
    });
    assertEquals("Invalid line", e.getMessage());



  }


}