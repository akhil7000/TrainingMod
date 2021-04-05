package com.training.utilities;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriter;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.List;
import java.util.Map;

public class ApiUtilities {
    File file = new File("src/test/resources/voteData.csv");

    public void writeCsv(int id) throws IOException {

        FileWriter fileWriter = new FileWriter(file);
        CSVWriter writer = new CSVWriter(fileWriter);
        writer.writeNext(new String[]{String.valueOf(id)});
        writer.close();
    }
}
