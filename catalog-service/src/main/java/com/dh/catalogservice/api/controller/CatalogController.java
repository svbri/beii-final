package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.api.service.impl.MovieService;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	private CatalogService catalogService;

	private final MovieService movieService;

	//@Autowired
	//public CatalogController(CatalogService catalogService) {
	//	this.catalogService = catalogService;
	//}

//	@GetMapping("/{genre}")
//	ResponseEntity<CatalogWS> getCatalogByGenre(@PathVariable String genre) {
//		CatalogWS catalogWS = catalogService.findCatalogByGenre(genre);
//
//		return Objects.isNull(catalogWS)
//				? ResponseEntity.notFound().build()
//				: ResponseEntity.ok(catalogWS);
//	}

	@Autowired
	public CatalogController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/{genre}")
	public ResponseEntity<List<MovieWS>> getGenre(@PathVariable String genre) {
		return movieService.findMovieByGenre(genre);
	}

	@GetMapping("/withErrors/{genre}")
	public ResponseEntity<List<MovieWS>> getGenre(@PathVariable String genre, @RequestParam("throwError") Boolean throwError) {
		return movieService.findMovieByGenre(genre, throwError);
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveMovie(@RequestBody MovieWS movieWS) {
		movieService.saveMovie(movieWS);
		return ResponseEntity.ok("The movie was sent to the queue");
	}
}
