package com.dh.seriesservice.controller;

import com.dh.seriesservice.model.Series;
import com.dh.seriesservice.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/series")
public class SeriesController {
    private SeriesService seriesService;

    @Autowired
    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @PostMapping("/create")
    public ResponseEntity<Series> create(@RequestBody Series series) {
        return ResponseEntity.status(HttpStatus.CREATED).body(seriesService.create(series));
    }

    @GetMapping("/list/{genre}")
    public ResponseEntity<List<Series>> list(@PathVariable String genre) {
        return ResponseEntity.ok(seriesService.list(genre));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Series> seriesList = seriesService.findAll();
        return seriesList.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(seriesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Series series = seriesService.findById(id);
        return Objects.isNull(series)
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(series);
    }
}
