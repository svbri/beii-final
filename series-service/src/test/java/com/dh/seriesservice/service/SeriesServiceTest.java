package com.dh.seriesservice.service;

import com.dh.seriesservice.model.Series;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SeriesServiceTest {

    @Autowired
    private SeriesService seriesService;

    @Test
    void create() {
        Series series = new Series();
        series.setId(1);
        series.setName("BH");
        Assertions.assertTrue(seriesService.create(series).getName().equals("BH"));
    }

    @Test
    void list() {
        Series series = new Series();
        series.setId(1);
        series.setName("BH");
        series.setGenre("Drama");
        seriesService.create(series);
        Assertions.assertTrue(seriesService.list("Drama").size() == 1);
    }
}