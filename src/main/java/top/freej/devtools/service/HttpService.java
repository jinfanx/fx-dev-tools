package top.freej.devtools.service;

import com.alibaba.fastjson.JSON;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

/**
 *
 * @ClassName HttpService
 * @Description
 * @author jinfanx
 * @Date 2019-12-20 12:02:41
 *
 */
public class HttpService {
    /**
     * HttpClient
     *
     * @param method
     * @param url
     * @param ignoreCertificate
     * @param jsonRequest
     * @param data
     * @return
     * @throws Exception
     */
    public static HttpResponse<String> doRequest(String method, String url, boolean ignoreCertificate,
                                                 boolean jsonRequest, Map<Object, Object> data) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest.Builder builder = HttpRequest.newBuilder().uri(URI.create(url));
        if ("get".equalsIgnoreCase(method)) {
            builder.GET();
        } else if ("post".equalsIgnoreCase(method)) {
            if (jsonRequest) {
                builder.POST(HttpRequest.BodyPublishers.ofString(JSON.toJSONString(data)));
            } else {
                StringBuilder formString = new StringBuilder();
                data.entrySet().forEach(entry -> {
                    formString.append(entry.getKey() + "=" + entry.getValue() + "&");
                });
                // 处理最后一个请求参数后的&
                formString.append("1=1");
                builder.POST(HttpRequest.BodyPublishers.ofString(formString.toString()));
            }
        } else {
            throw new Exception("method not support: " + method);
        }

        if (jsonRequest) {
            builder.setHeader("Content-Type", "application/json");
        }

        // 忽略证书
        if (ignoreCertificate && (url.startsWith("https") || url.startsWith("HTTPS"))) {
            // todo 此方法有误,
//            client.sslContext().init(null, new TrustManager[]{TrustAllX509TrustManager.getInstance()}, new SecureRandom());
        }

        return client.send(builder.build(), HttpResponse.BodyHandlers.ofString());
    }
}
