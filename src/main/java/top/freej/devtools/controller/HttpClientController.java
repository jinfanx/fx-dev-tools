package top.freej.devtools.controller;

import com.alibaba.fastjson.JSON;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import org.apache.commons.lang3.StringUtils;
import top.freej.devtools.service.HttpService;
import top.freej.devtools.util.MessageUtil;

import java.net.http.HttpResponse;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jinfanx
 * @ClassName HttpClientController
 * @Description
 * @Date 2019-12-20 12:03:01
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
    private TextArea requestParam;

    @FXML
    private void sendRequest() {
        String value = url.getValue();
        if (StringUtils.isEmpty(value) || "".equals(value.trim())) {
            MessageUtil.info(Alert.AlertType.ERROR, "url为空!");
            return;
        }

        if (!value.startsWith("http")) {
            MessageUtil.info(Alert.AlertType.ERROR, "无效url!");
            return;
        }

        // todo 错误处理

        // todo 结果展示

        Map<Object, Object> data = constructRequestParamByMethod();
        HttpResponse<String> response = null;
        try {
            response = HttpService.doRequest(method.getValue(), url.getValue(), ignoreCertificate.isSelected(),
                    jsonRequest.isSelected(), data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null) {
            response.headers().map().forEach((k, v) -> System.out.println(k + ":" + v.get(0)));
        }
    }

    private Map<Object, Object> constructRequestParamByMethod() {
        if ("get".equalsIgnoreCase(method.getValue())) {
            return null;
        }
        String requestStr = requestParam.getAccessibleText() == null ? "" : requestParam.getAccessibleText();
        if (jsonRequest.isSelected()) {
            return JSON.parseObject(requestStr, Map.class);
        } else {
            Map<Object, Object> result = new LinkedHashMap<>();
            // key = value format, one pair per line
            String[] pairs = requestStr.split(System.lineSeparator());
            for (String pair : pairs) {
                String[] kv = pair.split("=");
                if (kv != null && kv.length == 2) {
                    result.put(kv[0].trim(), kv[1].trim());
                }
            }
            return result;
        }
    }
}
