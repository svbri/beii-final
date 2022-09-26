package com.dh.seriesservice.service;

import com.dh.seriesservice.model.Series;
import com.dh.seriesservice.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService {
    private SeriesRepository seriesRepository;

    @Autowired
    public SeriesService(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    public Series create(Series series) {
        return seriesRepository.save(series);
    }

    public List<Series> list(String genre) {
        return seriesRepository.findByGenre(genre);
    }
}
