package com.training.utilities;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class JsonReaderUtility {

    public Map getJsonHashMap() {

        JsonObject jsonObject = new JsonObject();
        File jsonFile = new File("src/test/java/resources/testData.json");

        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(jsonFile));
            jsonObject = fileElement.getAsJsonObject();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        return gson.fromJson(jsonObject, Map.class);
    }
}

