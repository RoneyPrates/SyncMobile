package com.example.syncmobile;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface ApiService {
    @FormUrlEncoded
    @POST("/api/usuarios")
    Call<LoginResponse> login(@Field("email") String email, @Field("senha") String senha);

    @GET("/ordensdecompras")
    Call<List<Ordem>> getOrdens();
}
