package com.training.utilities;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class GetJsonValue {

    public Object getValue()  {

        Map<?, ?> map;
        Gson gson = new Gson();

        // create a reader
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir")+"\\src\\test\\resources\\Data.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // convert JSON file to map
        map = gson.fromJson(reader, Map.class);
        return map;
    }
}
