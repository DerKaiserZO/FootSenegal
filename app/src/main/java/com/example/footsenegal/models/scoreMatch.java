package com.example.footsenegal.models;

public class scoreMatch {
    private int Id;
    private String team_first;
    private String team_second;
    private int score_first;
    private int score_second;
    private int id_match;


    public scoreMatch(String team_first, String team_second, int score_first, int score_second, int id_match) {
        this.team_first = team_first;
        this.team_second = team_second;
        this.score_first = score_first;
        this.score_second = score_second;
        this.id_match = id_match;
    }

    public scoreMatch(int id, String team_first, String team_second, int score_first, int score_second, int id_match) {
        Id = id;
        this.team_first = team_first;
        this.team_second = team_second;
        this.score_first = score_first;
        this.score_second = score_second;
        this.id_match = id_match;
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

    public int getScore_first() {
        return score_first;
    }

    public void setScore_first(int score_first) {
        this.score_first = score_first;
    }

    public int getScore_second() {
        return score_second;
    }

    public void setScore_second(int score_second) {
        this.score_second = score_second;
    }

    public int getId_match() {
        return id_match;
    }

    public void setId_match(int id_match) {
        this.id_match = id_match;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "scoreMatch{" +
                "Id=" + Id +
                ", team_first='" + team_first + '\'' +
                ", team_second='" + team_second + '\'' +
                ", score_first=" + score_first +
                ", score_second=" + score_second +
                ", id_match=" + id_match +
                '}';
    }
}
