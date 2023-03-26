package persistence;

import org.json.JSONObject;

// represents an interface that returns this as JSON object
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
