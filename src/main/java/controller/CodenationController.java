package controller;

import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import net.sf.corn.converter.ParsingException;
import net.sf.corn.converter.json.JsTypeComplex;
import net.sf.corn.converter.json.JsTypeList;
import net.sf.corn.converter.json.JsonStringParser;
import net.sf.corn.httpclient.HttpClient;
import net.sf.corn.httpclient.HttpResponse;
import okhttp3.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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


    public void post() {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost uploadFile = new HttpPost("https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=8d1ef2778e0771b5aed722fdc9bdd28a0ef818c3");
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            //builder.addTextBody("field1", "yes", ContentType.TEXT_PLAIN);

            // This attaches the file to the POST:
            File f = new File("answer.json");

            builder.addBinaryBody(
                    "answer",
                    new FileInputStream(f),
                    ContentType.APPLICATION_OCTET_STREAM,
                    f.getName()
            );


            HttpEntity multipart = builder.build();
            uploadFile.setEntity(multipart);

            CloseableHttpResponse response = httpClient.execute(uploadFile);

            HttpEntity responseEntity = response.getEntity();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
