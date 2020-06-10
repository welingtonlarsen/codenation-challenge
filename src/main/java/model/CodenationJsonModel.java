package model;

import org.json.simple.JSONObject;

public class CodenationJsonModel {

    private String numeroCasas;
    private String token;
    private String cifrado;
    private String decifrado;
    private String resumoCriptografico;

    public CodenationJsonModel(JSONObject jsonObject) {
        this.numeroCasas = jsonObject.get("numero_casas").toString();
        this.token = jsonObject.get("token").toString();
        this.cifrado = jsonObject.get("cifrado").toString();
        this.decifrado = jsonObject.get("decifrado").toString();
        this.resumoCriptografico = jsonObject.get("resumo_criptografico").toString();
    }

    public String getNumeroCasas() {
        return numeroCasas;
    }

    public String getToken() {
        return token;
    }

    public String getCifrado() {
        return cifrado;
    }

    public String getDecifrado() {
        return decifrado;
    }

    public void setDecifrado(String decifrado) {
        this.decifrado = decifrado;
    }

    public String getResumoCriptografico() {
        return resumoCriptografico;
    }








}
