package com.training.utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonReaderUtility {
    public JsonObject jsonObject;

    public String getJson(String key) {
        File jsonFile = new File("src/test/java/resources/testData.json");
        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(jsonFile));
            jsonObject = fileElement.getAsJsonObject();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        return jsonObject.get(key).getAsString();
    }
}
