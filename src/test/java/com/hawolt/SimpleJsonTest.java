package com.hawolt;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleJsonTest {

    @Test
    public void testSimpleSourcing() {
        JSONObject object = new JSONObject("{\"test\":5}");
        JsonSource source = JsonSource.of(object);
        assertEquals("5", source.get("test"));
    }
}
