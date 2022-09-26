package com.dh.seriesservice.controller;

import com.dh.seriesservice.model.Series;
import com.dh.seriesservice.service.SeriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("series")
public class SeriesController {
    private SeriesService seriesService;

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
}
