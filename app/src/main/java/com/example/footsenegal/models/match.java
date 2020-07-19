package com.example.footsenegal.models;

public class match {
    private String team_first;
    private String team_second;
    private String Lieu;
    private int Prix;

    public match(String team_first, String team_second, String lieu, int prix) {
        this.team_first = team_first;
        this.team_second = team_second;
        Lieu = lieu;
        Prix = prix;
    }

    public String getTeam_first() {
        return team_first;
    }

    public void setTeam_first(String team_first) {
        this.team_first = team_first;
    }

    public String getTeam_second() {
        return team_second;
    }

    public void setTeam_second(String team_second) {
        this.team_second = team_second;
    }

    public String getLieu() {
        return Lieu;
    }

    public void setLieu(String lieu) {
        Lieu = lieu;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int prix) {
        Prix = prix;
    }

    @Override
    public String toString() {
        return "match{" +
                "team_first='" + team_first + '\'' +
                ", team_second='" + team_second + '\'' +
                ", Lieu='" + Lieu + '\'' +
                ", Prix=" + Prix +
                '}';
    }
}
