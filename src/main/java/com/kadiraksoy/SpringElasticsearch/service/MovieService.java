package com.kadiraksoy.SpringElasticsearch.service;


import com.kadiraksoy.SpringElasticsearch.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


}
