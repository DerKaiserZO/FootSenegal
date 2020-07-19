package com.example.footsenegal.models;

public class match {
    private String team_first;
    private String team_second;
    private String Lieu;
    private int Prix;
    private String DateMatch;

    public match(String team_first, String team_second, String lieu, int prix, String dateMatch) {
        this.team_first = team_first;
        this.team_second = team_second;
        Lieu = lieu;
        Prix = prix;
        DateMatch = dateMatch;
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

    public String getDateMatch() {
        return DateMatch;
    }

    public void setDateMatch(String dateMatch) {
        DateMatch = dateMatch;
    }

    @Override
    public String toString() {
        return "match{" +
                "team_first='" + team_first + '\'' +
                ", team_second='" + team_second + '\'' +
                ", Lieu='" + Lieu + '\'' +
                ", Prix=" + Prix +
                ", DateMatch=" + DateMatch +
                '}';
    }
}
