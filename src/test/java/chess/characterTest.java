package chess;

import static org.junit.Assert.*;

import org.junit.Test;

public class characterTest {
	@Test
	public void isWhitespaceTest() {
		assertEquals(true, Character.isWhitespace(' '));
		assertEquals(true, Character.isWhitespace('\t'));
		assertEquals(true, Character.isWhitespace('\n'));
		assertEquals(false, Character.isWhitespace('k'));
	}

	@Test
	public void testName() throws Exception {
		assertFalse(Character.isJavaIdentifierStart('^'));
		assertFalse(Character.isJavaIdentifierStart('*'));
		assertTrue(Character.isJavaIdentifierStart('a'));
		assertTrue(Character.isJavaIdentifierStart('A'));
	}
}
