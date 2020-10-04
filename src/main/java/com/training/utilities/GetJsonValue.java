package com.training.utilities;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public  class  GetJsonValue {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Getting JSON value from Data.json file
     * @return Object (key and value)
     */
    public Object getValue()  {
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir")+"\\src\\test\\resources\\Data.json"));
        } catch (Exception e) {
            logger.info("Error ", e);
        }
        return new Gson().fromJson(reader, Map.class);
    }
}