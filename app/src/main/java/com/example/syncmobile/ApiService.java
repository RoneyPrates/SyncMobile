package com.example.syncmobile;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiService {
    @GET("/ordensdecompras")
    Call<List<Ordem>> getOrdens();
}
