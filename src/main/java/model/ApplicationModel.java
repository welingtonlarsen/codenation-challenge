package model;

import controller.CodenationController;
import org.json.simple.JSONObject;
import utils.JsonUtils;
import utils.Sha1Utils;

public class ApplicationModel {

    private CodenationController codenationController;
    private CodenationJsonModel codenationJsonModel;
    private String jsonAux;
    private String fileLocation;

    public ApplicationModel setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
        return this;
    }

    public ApplicationModel getRequest() {
        this.codenationController = new CodenationController();
        this.jsonAux = codenationController.getRequest();
        return this;
    }

    public ApplicationModel save() {
        JSONObject jsonObject = JsonUtils.createJsonObject(fileLocation);
        codenationJsonModel = new CodenationJsonModel(jsonObject);
        JsonUtils.saveAsJsonFile(jsonAux, fileLocation);
        return this;
    }

    public ApplicationModel decode() {
        AlphabetModel alphabetModel = new AlphabetModel(codenationJsonModel.getNumeroCasas(), codenationJsonModel.getCifrado());
        alphabetModel.denconde();
        codenationJsonModel.setDecifrado(alphabetModel.getDeciphered());
        JsonUtils.saveAsJsonFile(codenationJsonModel.convertToJsonString(), fileLocation);
        return this;
    }

    public ApplicationModel cryptographicSummary() {
        codenationJsonModel = new CodenationJsonModel(JsonUtils.createJsonObject(fileLocation));
        codenationJsonModel.setResumoCriptografico(Sha1Utils.createSha1Hash(codenationJsonModel.getDecifrado()));
        JsonUtils.saveAsJsonFile(codenationJsonModel.convertToJsonString(), fileLocation);
        return this;
    }

    public ApplicationModel postRequest() {
        codenationController.postRequest();
        return this;
    }

    public ApplicationModel build() {
        return this;
    }

}
