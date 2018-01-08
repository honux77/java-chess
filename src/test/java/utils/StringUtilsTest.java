package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {
	@Test
	public void appendNewLine() {
		String line = "test";
		String result = StringUtils.appendNewLine(line);
		assertEquals(line + StringUtils.NEWLINE, result);
	}
}