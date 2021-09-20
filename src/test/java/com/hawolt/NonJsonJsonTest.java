package com.hawolt;

import com.hawolt.exception.InvalidObjectException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NonJsonJsonTest {

    @Test
    public void testFormatting() {
        Object o = new Object();
        try {
            JsonSource source = JsonSource.of(o);
        } catch (Exception e) {
            assertEquals(InvalidObjectException.class, e.getClass());
        }
    }
}
