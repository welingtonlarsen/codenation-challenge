package application;

import controller.CodenationController;
import model.AlphabetModel;
import model.CodenationJsonModel;
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
        CodenationJsonModel jsonModel = new CodenationJsonModel(jsonObject);

        AlphabetModel alphabetModel = new AlphabetModel(Integer.parseInt(jsonModel.getNumeroCasas()), jsonModel.getCifrado());
        alphabetModel.denconde();

        jsonModel.setDecifrado(alphabetModel.getDeciphered());



        System.out.println("break");








    }
}
