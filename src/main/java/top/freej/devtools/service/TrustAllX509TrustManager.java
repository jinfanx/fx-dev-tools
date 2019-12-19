package top.freej.devtools.service;

import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

/**
 *
 * @ClassName TrustAllX509TrustManager
 * @Description
 * @author jinfanx
 * @Date 2019-12-20 12:02:30
 *
 */
public class TrustAllX509TrustManager implements X509TrustManager {
    private static TrustAllX509TrustManager instance = new TrustAllX509TrustManager();

    public static TrustAllX509TrustManager getInstance() {
        return instance;
    }

    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {

    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
