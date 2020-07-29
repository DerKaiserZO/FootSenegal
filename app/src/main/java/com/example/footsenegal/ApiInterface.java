package com.example.footsenegal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("equipes/1")
    Call<List<com.example.footsenegal.models.equipe>> getListEquipeLigue1();

    @GET("matchs/1")
    Call<List<com.example.footsenegal.models.match>> getListMatchsLigue1();

    @GET("matchs-results/1")
    Call<List<com.example.footsenegal.models.scoreMatch>> getListMatchsResultsLigue1();

    @GET("equipes/2")
    Call<List<com.example.footsenegal.models.equipe>> getListEquipeLigue2();

    @GET("matchs/2")
    Call<List<com.example.footsenegal.models.match>> getListMatchsLigue2();

    @GET("matchs-results/2")
    Call<List<com.example.footsenegal.models.scoreMatch>> getListMatchsResultsLigue2();

    @GET("connexion")
    Call<com.example.footsenegal.models.status> getConnexion(@Query("login") String login, @Query("pass") String pass);
}
