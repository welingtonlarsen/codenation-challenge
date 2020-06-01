package application;

import controller.CodenationController;
import model.JsonModel;
import org.json.simple.JSONObject;
import utils.JsonUtils;

public class Application {
    public static void main(String[] args) {

        String urlGetRequest = "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=8d1ef2778e0771b5aed722fdc9bdd28a0ef818c3";
        String fileLocation = "answer.json";

        CodenationController codenationController = new CodenationController();
        String json = codenationController.getJsonFile(urlGetRequest);
        JsonUtils.saveAsJsonFile(json, fileLocation);

        JSONObject jsonObject = JsonUtils.createJsonObject(fileLocation);
        JsonModel jsonModel = new JsonModel(jsonObject);


    }
}
