package com.db.configuration;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;

public class ClientConfiguration {
    @Bean
    public OkHttpClient client(){
       return new OkHttpClient();
    }
}
