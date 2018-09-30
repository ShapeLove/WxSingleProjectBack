package com.shape.singleproject.util;

import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.parser.Entity;
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

    public String uploadFile(String urlf, String filePath) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://192.168.56.101:4869/upload");
        httpPost.addHeader("Content-Type","jpeg");
        //解决中文乱码问题
        FileEntity fileEntity = new FileEntity(new File("D:\\es.PNG"));

        httpPost.setEntity(fileEntity);
        HttpEntity reentity = httpclient.execute(httpPost).getEntity();
        return EntityUtils.toString(reentity);
    }
}
