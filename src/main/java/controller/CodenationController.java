package controller;

import net.sf.corn.converter.ParsingException;
import net.sf.corn.converter.json.JsTypeComplex;
import net.sf.corn.converter.json.JsTypeList;
import net.sf.corn.converter.json.JsonStringParser;
import net.sf.corn.httpclient.HttpClient;
import net.sf.corn.httpclient.HttpResponse;

import java.io.IOException;
import java.net.*;

public class CodenationController {

    public String getJsonFile(String urlString) {
        String jsonString = "";

        try {
            HttpClient client = new HttpClient(new URI(urlString));
            HttpResponse response = client.sendData(HttpClient.HTTP_METHOD.GET);

            if (!response.hasError()) {
                jsonString = response.getData();
                return jsonString;
            }
        } catch (URISyntaxException | IOException exception) {
            exception.printStackTrace();
        }

        return jsonString;
    }
}
