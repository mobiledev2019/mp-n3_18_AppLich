package com.example.administrator.applich.network;

public class ApiClient {
    public static final String baseurl="https://wgames.ezlifetech.com/horoscope/API/";
    public static DataService getService(){
        return  RetrofitClient.getClient(baseurl).create(DataService.class);
    }
}
