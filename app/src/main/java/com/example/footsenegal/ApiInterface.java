package com.example.footsenegal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("equipes")
    Call<List<com.example.footsenegal.models.equipe>> getListEquipe();
}
