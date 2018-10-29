package com.shape.singleproject.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Entity;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileSystem;

import static org.apache.commons.codec.Charsets.UTF_8;

@Component
@LogExceptAop
@TimeAop
public class HttpUtil {

    @Value("${wx.appid:wx193b7550e9f8c425}")
    private String appid;

    @Value("${wx.appsecret:1040a9d44fb6fbb196086dc09119c4de}")
    private String appsecret;

    @Value("${shape.imageserver.url:http://192.168.56.102:4869}")
    private String imageServer;

    public JSONObject uploadFile(String filePath) throws IOException {
        HttpPost httpPost = new HttpPost(imageServer + "/upload");
        httpPost.addHeader("Content-Type","jpeg");
        //解决中文乱码问题
        FileEntity fileEntity = new FileEntity(new File(filePath));
        httpPost.setEntity(fileEntity);
        return commonJSONRequest(httpPost);
    }

    public JSONObject uploadFile(MultipartFile file) throws IOException {
        HttpPost httpPost = new HttpPost(imageServer + "/upload");
        httpPost.addHeader("Content-Type","jpeg");
        //解决中文乱码问题
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(file.getBytes(), ContentType.IMAGE_JPEG);
        httpPost.setEntity(byteArrayEntity);
        return commonJSONRequest(httpPost);
    }

    public boolean deleteImage(String md5) throws IOException {
        HttpGet httpGet = new HttpGet(String.format(imageServer + "/admin?md5=%s&t=1", md5));
        String result = commonHtmlRequest(httpGet);
        if (result.contains("Successful")) {
            return true;
        }else {
            throw new RuntimeException(String.format("HttpUtil.deleteImage error param: %s, error: %s", md5, result));
        }
    }

    public JSONObject getWxOpenid(String code) throws IOException {
        HttpGet httpGet = new HttpGet(String.format("https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code", appid, appsecret, code));
        httpGet.setHeader("Content-Type", "json");
        return commonJSONRequest(httpGet);
    }

    private JSONObject commonJSONRequest(HttpUriRequest request) throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpEntity result = httpclient.execute(request).getEntity();
            return JSON.parseObject(EntityUtils.toString(result));
        }
    }

    private String commonHtmlRequest(HttpUriRequest request) throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpEntity result = httpclient.execute(request).getEntity();
            return EntityUtils.toString(result);
        }
    }
}
