package application;

import model.ApplicationModel;

public class Application {
    public static void main(String[] args) {
        ApplicationModel ab = new ApplicationModel()
                .setFileLocation("answer.json")
                .getRequest()
                .save()
                .decode()
                .cryptographicSummary()
                .postRequest()
                .build();
    }
}
