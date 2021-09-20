package com.hawolt;

import com.hawolt.exception.InvalidKeyException;
import com.hawolt.exception.InvalidObjectException;
import com.hawolt.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class JsonSource {

    public static JsonSource of(Path path) throws IOException {
        try (InputStream stream = Core.getFileAsStream(path)) {
            return JsonSource.of(Core.read(stream).toString());
        }
    }

    public static JsonSource of(Object json) {
        JsonSource source = new JsonSource(json);
        for (String key : source.config.keySet()) {
            if (key == null) continue;
            Logger.debug("sourcing: {}={}", key, source.config.get(key));
        }
        return source;
    }

    private Map<String, String> config = new HashMap<>();

    private JsonSource(Object o) {
        if (o instanceof String) {
            boolean isObject = ((String) o).charAt(0) == '{';
            if (isObject) {
                parse(null, new JSONObject(o.toString()));
            } else {
                parse(null, new JSONArray(o.toString()));
            }
        } else {
            parse(null, o);
        }
    }

    private void parse(String identifier, Object o) {
        if (o instanceof JSONObject) {
            JSONObject object = (JSONObject) o;
            for (String key : object.keySet()) {
                parse(identifier == null ? key : String.join(".", identifier, key), object.get(key));
            }
        } else if (o instanceof JSONArray) {
            JSONArray array = (JSONArray) o;
            for (int i = 0; i < array.length(); i++) {
                parse(identifier == null ? String.valueOf(i) : String.join(".", identifier, String.valueOf(i)), array.get(i));
            }
        } else {
            if (identifier == null) {
                throw new InvalidObjectException(o);
            } else {
                config.put(identifier, o.toString());
            }
        }
    }

    public String getOrThrow(String key, InvalidKeyException e) throws InvalidKeyException {
        if (!containsKey(key)) throw e;
        return get(key);
    }

    public String getOrDefault(String key, String d) {
        return config.getOrDefault(key, d);
    }

    public String get(String key) {
        return config.get(key);
    }

    public boolean containsKey(String key) {
        return config.containsKey(key);
    }
}
