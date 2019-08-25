package data;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * <p>
 * Author: Mirza S. / mirza.suljic.ba@gmail.com <br>
 * Date: 23.8.2019.
 * </p>
 */
@SuppressWarnings ("MessageMissingOnJUnitAssertion")
class CableTest {

  @Test
  void enumDemo() {
    assertFalse(Cable.values().length < 1);

    // gle ovo jes' gotiva:
    List<Cable> sviKablovi = Arrays.asList(Cable.values()); // svaki enum je automatski i niz svog sadržaja, taj niz možeš uzeti u listu/set i time raditi
    assertFalse(sviKablovi.isEmpty());

    for (Cable type : sviKablovi) {
      System.out.println("enum " + type + " ima string " + type.getName());
    }
  }

}