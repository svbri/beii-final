package com.dh.catalogservice.api.service.feign;

import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "movie-service")
public interface MovieClient {

    @GetMapping("/movies/{genre}")
    ResponseEntity<List<MovieWS>> findMovieByGenre(@PathVariable("genre") String genre);

    @GetMapping("/movies/withErrors/{genre}")
    ResponseEntity<List<MovieWS>> getMovieByGenreWithThrowError(@PathVariable(value = "genre") String genre,
                                                                 @RequestParam("throwError") boolean throwError);
}