package com.tubes.tubes.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //IP Address nya sesuaikan dengan IP Address device yang digunakan, cara mengeceknya bisa dengan menggunakan cmd kemudian masukkan command ipconfig setelah itu akan muncul IP Address device yang digunakan lalu ganti "192.168.100.54" dengan IP Address device kalian.
    public static final String BASE_URL = "http://192.168.100.54/rest_ci/index.php/";
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
