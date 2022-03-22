package com.springcloud.www;

import java.net.http.HttpClient;
import java.time.Duration;

public class SpringCloudApplication {

    public static void main(String[] args) {

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(20))
                .build();


        System.out.println("Http client");

        var name = "hello";

    }
}
