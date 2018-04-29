package by.bntu.fitr.povt.prostrmk.itnews.model.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonWork {

    public static JSONObject getJsonFromUrl(String url) throws Exception{
        InputStream is = null;
        String result;
        JSONObject jArray = null;

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        HttpResponse response = null;
        response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        is = entity.getContent();

        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null){
            sb.append(line).append("\n");
        }
        is.close();
        result = sb.toString();
        jArray = new JSONObject(result);
        return jArray;

    }

}
