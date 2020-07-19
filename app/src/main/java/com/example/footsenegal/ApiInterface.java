package com.example.footsenegal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;

public interface ApiInterface {
    @GET("equipes/1")
    Call<List<com.example.footsenegal.models.equipe>> getListEquipeLigue1();

    @GET("matchs/1")
    Call<List<com.example.footsenegal.models.match>> getListMatchsLigue1();
}
