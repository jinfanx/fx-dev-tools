package top.freej.fxhttpclient;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class MainController {
    @FXML
    private ComboBox<String> method;

    @FXML
    private ComboBox<String> url;

    @FXML
    private CheckBox ignoreCertificate;

    @FXML
    private CheckBox jsonRequest;

    @FXML
    private void sendRequest() {
        System.out.println("method:" + method.getValue());
        System.out.println("url:" + url.getValue());
        System.out.println("ignoreCertificate" + ignoreCertificate.isSelected());
        System.out.println("jsonRequest:" + jsonRequest.isSelected());
    }
}
