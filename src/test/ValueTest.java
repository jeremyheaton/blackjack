

import static org.junit.Assert.assertTrue;
import main.java.Value;

import org.junit.Test;

public class ValueTest {

	@Test
	public void test() {
		assertTrue(Value.ACE.getValue() == 11);
		assertTrue(Value.DEUCE.getValue() == 2);
		assertTrue(Value.THREE.getValue() == 3);
		assertTrue(Value.FOUR.getValue() == 4);
		assertTrue(Value.FIVE.getValue() == 5);
		assertTrue(Value.SIX.getValue() == 6);
		assertTrue(Value.SEVEN.getValue() == 7);
		assertTrue(Value.EIGHT.getValue() == 8);
		assertTrue(Value.NINE.getValue() == 9);
		assertTrue(Value.TEN.getValue() == 10);
		assertTrue(Value.JACK.getValue() == 10);
		assertTrue(Value.QUEEN.getValue() == 10);
		assertTrue(Value.KING.getValue() == 10);
	}

}
