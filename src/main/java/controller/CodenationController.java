package controller;


import okhttp3.*;

import java.io.File;
import java.io.IOException;


public class CodenationController {

    private String urlGetRequest;
    private String urlPostRequest;

    public CodenationController() {
        this.urlGetRequest = "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=8d1ef2778e0771b5aed722fdc9bdd28a0ef818c3";
        this.urlPostRequest = "https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=8d1ef2778e0771b5aed722fdc9bdd28a0ef818c3";
    }

    public String getRequest() {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(urlGetRequest)
                .method("GET", null)
                .addHeader("Content-Type", "multipart/form-data")
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void postRequest() {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("multipart/form-data");

        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("answer", "/D:/git-welington/codenation-challenge/answer.json",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("/D:/git-welington/codenation-challenge/answer.json")))
                .build();

        Request request = new Request.Builder()
                .url(urlPostRequest)
                .method("POST", body)
                .addHeader("Content-Type", "multipart/form-data")
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response != null) {
                System.out.println(response.body().string());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
