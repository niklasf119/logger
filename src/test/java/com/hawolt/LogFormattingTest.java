package com.hawolt;

import org.junit.Test;
import com.hawolt.logging.Logger;

import static org.junit.Assert.assertEquals;

public class LogFormattingTest {

    @Test
    public void testFormatting() {
        assertEquals("Test 123", Logger.format("Test {}", 123));
    }
}
