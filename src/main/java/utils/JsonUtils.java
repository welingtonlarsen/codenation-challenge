package utils;


import java.io.FileWriter;
import java.io.IOException;

public class JsonUtils {

    public static void saveJsonFile(String jsonToSave) {
        try {
            FileWriter fileWriter = new FileWriter("answer.json");
            fileWriter.write(jsonToSave);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
