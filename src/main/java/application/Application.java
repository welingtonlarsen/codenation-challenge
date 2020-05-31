package application;

import controller.CodenationController;
import utils.JsonUtils;

public class Application {
    public static void main(String[] args) {
        CodenationController codenationController = new CodenationController();
        String json = codenationController.getJsonFile("https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=8d1ef2778e0771b5aed722fdc9bdd28a0ef818c3");
        JsonUtils.saveJsonFile(json);

    }
}
