package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.api.service.feign.MovieClient;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
	private MovieClient movieClient;

	@Autowired
	public CatalogServiceImpl(MovieClient movieClient) {
		this.movieClient = movieClient;
	}

	@Override
	public CatalogWS findCatalogByGenre(String genre) {
		ResponseEntity<List<MovieWS>> response = movieClient.findMovieByGenre(genre);
		return new CatalogWS(genre, response.getBody());
	}
}
