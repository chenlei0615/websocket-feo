package com.sunlands.feo.demo.util;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @Project : score_query_backend
 * @Package Name : com.sunlands.wx.feo.utils
 * @Description : :信任管理器
 * @Author : chenlei
 * @Create Date : 2018年05月09日 20:25
 * @ModificationHistory Who   When     What
 * ------------    --------------    ---------------------------------
 */
public class MyX509TrustManager implements X509TrustManager {
    // 检查客户端证书
    public void checkClientTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }

    // 检查服务器端证书
    public void checkServerTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }

    // 返回受信任的X509证书数组
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}

