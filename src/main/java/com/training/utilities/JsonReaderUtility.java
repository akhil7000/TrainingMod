package com.training.utilities;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class JsonReaderUtility {

    public Map<String, String> getMap() {

        JsonObject jsonObject = new JsonObject();
        File jsonFile = new File("src/test/java/resources/testData.json");

        try {
            jsonObject = JsonParser.parseReader(new FileReader(jsonFile)).getAsJsonObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return new Gson().fromJson(jsonObject, Map.class);
    }
}

