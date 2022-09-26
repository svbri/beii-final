package com.dh.seriesservice.model;

import java.util.List;

public class Seasons {
    private Integer id;
    private String seasonNumber;
    private List<Chapter> chapterList;

    public Seasons() {
    }

    public Seasons(String seasonNumber, List<Chapter> chapterList) {
        this.seasonNumber = seasonNumber;
        this.chapterList = chapterList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(String seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }
}
