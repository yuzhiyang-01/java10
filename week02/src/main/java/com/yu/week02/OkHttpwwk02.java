package com.yu.week02;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpwwk02 {

    public static OkHttpClient okHttpClient = new OkHttpClient();

    public static String get(String url ){
        Request build = new Request.Builder().url(url).build();
        try(Response  response = okHttpClient.newCall(build).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String url ="http://localhost:8081";
        String message = get(url);
        System.out.println(message);
    }

}
