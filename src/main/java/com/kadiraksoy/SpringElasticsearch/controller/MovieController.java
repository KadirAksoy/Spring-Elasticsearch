package com.kadiraksoy.SpringElasticsearch.controller;


import com.kadiraksoy.SpringElasticsearch.dto.MovieDto;
import com.kadiraksoy.SpringElasticsearch.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/save")
    public ResponseEntity<MovieDto> saveBook(@RequestBody MovieDto movie) {
        return ResponseEntity.ok(movieService.saveMovie(movie));
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<MovieDto>> allBooks() {
        return ResponseEntity.ok(movieService.allMovie());
    }

    @GetMapping("/{search}")
    public ResponseEntity<Page<MovieDto>> searchMovie(@PathVariable String search) {
        return ResponseEntity.ok(movieService.searchMovieName(search));
    }

    @GetMapping("/find_name/{name}")
    public ResponseEntity<List<MovieDto>> findByName(@PathVariable String name) {
        LOG.info("Getting find movie By name, ", name);
        return ResponseEntity.ok(movieService.getMovieByName(name));
    }

    @GetMapping("/getByRatingInterval/start/{start}/end/{end}")
    public ResponseEntity<List<MovieDto>> getByRatingInterval(@PathVariable Double start, @PathVariable Double end) {
        LOG.info("getByRatingInterval start : " + start + " , end : " + end);
        return ResponseEntity.ok(movieService.getByRatingInterval(start, end));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MovieDto> updateMovie(@RequestBody MovieDto movieDto,@PathVariable String id) {
        LOG.info("Updating Movie with id {}", id);
        movieService.update(id,movieDto);
        return ResponseEntity.ok(movieDto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteEmployeeByID(@PathVariable String id) {
        LOG.info("Deleting Movie with id {}", id);
        movieService.deleteMovie(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<MovieDto> findById(@PathVariable String id) {
        LOG.info("Getting find movie By id, ", id);
        return ResponseEntity.ok(movieService.findByMovieId(id));
    }
}
