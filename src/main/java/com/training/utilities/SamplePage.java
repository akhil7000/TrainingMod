package com.training.utilities;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class SamplePage {
    public String getUrl()  {
         Logger logger = LoggerFactory.getLogger(this.getClass());
        Map<?, ?> map;
        String getURl = null;
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
            getURl = (String) entry.getValue();
        }
        return getURl;
    }
}
