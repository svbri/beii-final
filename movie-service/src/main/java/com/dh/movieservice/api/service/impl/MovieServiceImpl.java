package com.dh.movieservice.api.service.impl;

import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.domain.model.MovieInfo;
import com.dh.movieservice.domain.repository.MovieRepository;
import com.dh.movieservice.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import com.dh.movieservice.api.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MovieServiceImpl implements MovieService {
		private static final Logger LOG = LoggerFactory.getLogger(MovieService.class);

		private final MovieRepository repository;
		private final RedisUtils redisUtils;

		@Autowired
		public MovieServiceImpl(MovieRepository movieRepository, RedisUtils redisUtils) {
			this.repository = movieRepository;
			this.redisUtils = redisUtils;
		}

		public List<Movie> getListByGenre(String genre) {
			MovieInfo movieInfo = redisUtils.getMovieInfo(genre);
			if (Objects.nonNull(movieInfo)) {
				return movieInfo.getMovies();
			}
			List<Movie> movies = repository.findAllByGenre(genre);
			redisUtils.createMovieInfo(genre, movies);
			return movies;
		}

		public List<Movie> getListByGenre(String genre, Boolean throwError) {
			LOG.info("se van a buscar las peliculas por género");
			if (throwError) {
				LOG.error("Hubo un error al buscar las películas");
				throw new RuntimeException();
			}
			return repository.findAllByGenre(genre);
		}

		@RabbitListener(queues = "${queue.movie.name}")
		public void save(Movie movie) {
			LOG.info("Se recibio una movie a través de rabbit " + movie.toString());
			saveMovie(movie);
		}

		public Movie saveMovie(Movie movie) {
			return repository.save(movie);
		}

	}
