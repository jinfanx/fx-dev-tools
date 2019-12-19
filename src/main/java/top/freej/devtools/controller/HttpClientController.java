package top.freej.devtools.controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import top.freej.devtools.service.HttpService;

import java.net.http.HttpResponse;
import java.util.Map;

/**
 *
 * @ClassName HttpClientController
 * @Description 
 * @author jinfanx
 * @Date 2019-12-20 12:03:01 
 *
 */
public class HttpClientController {
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
        // todo param validate

        // todo error handle, such as service not available

        // todo resolve response

        Map<Object, Object> data = Map.of("name", "user1", "state", "0");
        HttpResponse<String> response = null;
        try {
            response = HttpService.doRequest(method.getValue(), url.getValue(), ignoreCertificate.isSelected(),
                    jsonRequest.isSelected(), data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(response.headers());
        System.out.println(response.body());
    }
}
