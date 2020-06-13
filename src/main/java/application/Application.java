package application;

import controller.CodenationController;
import model.AlphabetModel;
import model.CodenationJsonModel;
import org.json.simple.JSONObject;
import utils.JsonUtils;
import utils.Sha1Utils;

public class Application {
    public static void main(String[] args) {


        //Informações gerais
        String fileLocation = "answer.json";

        //GetRequest
        CodenationController codenationController = new CodenationController();
        String json = codenationController.getRequest();

        //Salva o json file na localização informada
        JsonUtils.saveAsJsonFile(json, fileLocation);

        //Cria um JSONObject a partir do arquivo salvo
        JSONObject jsonObject = JsonUtils.createJsonObject(fileLocation);

        //Cria um objeto CodenationJsonModel a partir o JSONObject
        CodenationJsonModel codenationJsonModel = new CodenationJsonModel(jsonObject);

        //Cria o objeto AlphabetModel e decifra de acordo com o numero de casas desejado
        AlphabetModel alphabetModel = new AlphabetModel(codenationJsonModel.getNumeroCasas(), codenationJsonModel.getCifrado());
        alphabetModel.denconde();

        //Seta o decifrado do CodenationJsonModel
        codenationJsonModel.setDecifrado(alphabetModel.getDeciphered());

        //Salva o json file, agora com a propriedade decifrado
        JsonUtils.saveAsJsonFile(codenationJsonModel.convertToJsonString(), fileLocation);

        //Recupera o json file salvo para um CodenationJsonModel
        codenationJsonModel = new CodenationJsonModel(JsonUtils.createJsonObject(fileLocation));

        //Gera o resumo criptografico
        codenationJsonModel.setResumoCriptografico(Sha1Utils.createSha1Hash(codenationJsonModel.getDecifrado()));

        //Salva novamente o arquivo
        JsonUtils.saveAsJsonFile(codenationJsonModel.convertToJsonString(), fileLocation);

        //PostRequest
        codenationController.postRequest();

        
    }
}
