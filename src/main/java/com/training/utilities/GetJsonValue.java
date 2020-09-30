package com.training.utilities;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class GetJsonValue {
    public String getValue(String key)  {

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

        // print map entries
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if(key.equalsIgnoreCase((String) entry.getKey()))
            return (String) entry.getValue();
        }
        return null;
    }
}
