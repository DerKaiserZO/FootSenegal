package com.example.footsenegal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("equipes/{id}")
    Call<List<com.example.footsenegal.models.equipe>> getListEquipeLigue(@Path("id") int id);

    @GET("matchs/{id}")
    Call<List<com.example.footsenegal.models.match>> getListMatchsLigue(@Path("id") int id);

    @GET("matchs-results/{id}")
    Call<List<com.example.footsenegal.models.scoreMatch>> getListMatchsResultsLigue(@Path("id") int id);

    @GET("connexion")
    Call<com.example.footsenegal.models.status> getConnexion(@Query("login") String login, @Query("pass") String pass);
}
