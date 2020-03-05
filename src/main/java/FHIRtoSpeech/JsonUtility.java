package FHIRtoSpeech;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonUtility {
    public JsonElement parseRawJsonIntoJsonTree(String rawJson) {
        JsonParser parser = new JsonParser();
        JsonElement jsonTree = parser.parse(rawJson);
        return jsonTree;
    }

    public String checkJsonTreeType(JsonElement jsonTree) {
        /*
        * The parsed JSON tree structure consists of objects from the GSON API.
        * The root of a JSON tree structure is a JsonElement object.
        * You can find out what type of JSON element it represents using one of the type checking methods:
        */
        if(jsonTree.isJsonObject() == true) {
            return "JsonObject";
        } else if(jsonTree.isJsonArray() == true) {
            return "JsonArray";
        } else if(jsonTree.isJsonNull() == true) {
            return "JsonNull";
        } else if(jsonTree.isJsonPrimitive() == true) {
            return "JsonPrimitive";
        }
        return "";
    }
}
