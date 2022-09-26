package com.dh.seriesservice.model;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Series {
    @Id
    private Integer id;
    private String name;
    private String genre;
    private List<Seasons> seasonsList;

    public Series() {
    }

    public Series(Integer id, String name, String genre, List<Seasons> seasonsList) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.seasonsList = seasonsList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Seasons> getSeasonsList() {
        return seasonsList;
    }

    public void setSeasonsList(List<Seasons> seasonsList) {
        this.seasonsList = seasonsList;
    }
}
