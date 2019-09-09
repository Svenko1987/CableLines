import application.Computer;
import application.Controller;
import data.Cable;
import data.Line;
import data.Purpose;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SuppressWarnings({"MessageMissingOnJUnitAssertion", "SpellCheckingInspection", "MagicNumber"})
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

        Line line = new Line("32A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 2, 1);
        Line line2 = new Line("37A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 5, 2);
        Line line3 = new Line("14", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 2, 1);
        lines.add(line);
        lines.add(line2);
        lines.add(line3);
        assertEquals(4, computer.sumSameFloor(lines, 1));

    }

    @Test
    void sumSameLineTest() {
        Line line = new Line("32A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 2, 1);
        Line line2 = new Line("32A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 5, 1);
        computer.addToLines(lines, line);
        computer.addToLines(lines, line2);
        assertEquals(7, computer.selectLine(lines, line).getAmount());


    }

    @Test
    void serelisationTest() {
        Line line1 = new Line("32A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 2, 1);
        Line line2 = new Line("3A", Purpose.CONNECTION, "Veza", Cable.COMMUNICATION_CAT4, 4, 1);
        Line line3 = new Line("16", Purpose.OUTLET, "Kuhinja", Cable.FLEXIBLE_3X25, 123, 1);
        Line line4 = new Line("52A", Purpose.DATAFLOW, "Portirnica", Cable.COMMUNICATION_CAT7, 6666, 2);
        Line line5 = new Line("9", Purpose.POWERSUPPLY, "Elektro motor", Cable.FLEXIBLE_5X40, 80, 0);
        Collection<Line> ser = new ArrayList<>();
        Collection<Line> deser;

        computer.addToLines(ser, line1);
        computer.addToLines(ser, line2);
        computer.addToLines(ser, line3);
        computer.addToLines(ser, line4);
        computer.addToLines(ser, line5);

        String location = "C:\\Users\\DT User3\\Documents\\CableLines\\DataTest.txt";
        computer.saveLines(ser, location);
        deser = computer.loadLines(location);
        System.out.println(deser.toString());

        assertEquals(ser, deser);


    }

    @Test
    void summAllBuildingTest() {

        Line line = new Line("32A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 2, 1);
        Line line2 = new Line("37A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 5, 2);
        Line line3 = new Line("14", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 2, 1);
        lines.add(line);
        lines.add(line2);
        lines.add(line3);
        assertEquals(9, computer.sumAllBuilding(lines));
    }

    @Test
    void updateLineTest() {
        Line line = new Line("32A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 2, 1);
        Line line2 = new Line("32A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 5, 1);
        lines.add(line);
        computer.updateLine(lines, line, line2);
        assertEquals(computer.selectLine(lines, line).getAmount(), line2.getAmount());


    }

    @Test
    void summSameCableTest() {
        Line line = new Line("32A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X15, 2, 1);
        Line line2 = new Line("37A", Purpose.LIGHTS, "Hodnik", Cable.FLEXIBLE_3X25, 5, 2);
        Line line3 = new Line("14", Purpose.OUTLET, "Hodnik", Cable.FLEXIBLE_3X15, 5, 3);
        lines.add(line);
        lines.add(line2);
        lines.add(line3);
        assertEquals(7, computer.sumSameCable(lines, Cable.FLEXIBLE_3X15));
    }

    @Test
    void illegalEntryTest() {
        Cable cable = Cable.FLEXIBLE_3X15;
        Purpose purpose = Purpose.LIGHTS;
        Line invalidLine = new Line("a", purpose, "no note", cable, -8, 2);


        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            computer.addToLines(lines, invalidLine);
        });
        assertEquals("Invalid line", e.getMessage());


    }


}