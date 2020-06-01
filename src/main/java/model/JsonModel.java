package model;

import org.json.simple.JSONObject;

public class JsonModel {

    private String numeroCasas;
    private String token;
    private String cifrado;
    private String decifrado;
    private String resumoCriptografico;


    public JsonModel(JSONObject jsonObject) {
        this.numeroCasas = jsonObject.get("numero_casas").toString();
        this.token = jsonObject.get("token").toString();
        this.cifrado = jsonObject.get("cifrado").toString();
        this.decifrado = jsonObject.get("decifrado").toString();
        this.resumoCriptografico = jsonObject.get("resumo_criptografico").toString();
    }



    public String getNumeroCasas() {
        return numeroCasas;
    }

    public void setNumeroCasas(String numeroCasas) {
        this.numeroCasas = numeroCasas;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCifrado() {
        return cifrado;
    }

    public void setCifrado(String cifrado) {
        this.cifrado = cifrado;
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

    public void setResumoCriptografico(String resumoCriptografico) {
        this.resumoCriptografico = resumoCriptografico;
    }
}
