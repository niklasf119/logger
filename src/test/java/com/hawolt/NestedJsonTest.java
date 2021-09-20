package com.hawolt;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NestedJsonTest {

    @Test
    public void testNestedJson() {
        JSONObject object = new JSONObject("{\"test\":{\"nested\":[6]}}");
        JsonSource source = JsonSource.of(object);
        assertEquals("6", source.get("test.nested.0"));
    }
}
