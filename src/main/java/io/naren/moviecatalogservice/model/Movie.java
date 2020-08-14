package io.naren.moviecatalogservice.model;

public class Movie {

    public Movie(){}

    private String movieId;
    private String name;
    private String desc;

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public Movie(String movieId, String name, String desc) {
        this.movieId = movieId;
        this.name = name;
        this.desc = desc;
    }

    public Movie(String movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

}
