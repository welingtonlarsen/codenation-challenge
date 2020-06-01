package utils;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonUtils {

    public static void saveAsJsonFile(String jsonToSave, String directoryToSaveTheFile) {
        try {
            FileWriter fileWriter = new FileWriter(directoryToSaveTheFile);
            fileWriter.write(jsonToSave);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static JSONObject createJsonObject(String directoryToTakeTheFile) {
        JSONObject jsonObject = null;
        try {
            FileReader fileReader = new FileReader(directoryToTakeTheFile);
            JSONParser jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(fileReader);

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

}
