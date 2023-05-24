package com.kadiraksoy.SpringElasticsearch.service;


import com.kadiraksoy.SpringElasticsearch.dto.MovieDto;
import com.kadiraksoy.SpringElasticsearch.dto.converter.MovieDtoConverter;
import com.kadiraksoy.SpringElasticsearch.model.Movie;
import com.kadiraksoy.SpringElasticsearch.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieDtoConverter movieDtoConverter;

    public MovieService(MovieRepository movieRepository, MovieDtoConverter movieDtoConverter) {
        this.movieRepository = movieRepository;
        this.movieDtoConverter = movieDtoConverter;
    }

   public MovieDto findByMovieId(String id){
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        return optionalMovie.map(movieDtoConverter::convert).orElseThrow();
   }

   public List<MovieDto> getMovieByName(String name){
       List<Movie> optionalMovie = movieRepository.findByName(name);
       List<MovieDto> movieDtoList = new ArrayList<>();

       for (Movie movie : optionalMovie){
           movieDtoList.add(movieDtoConverter.convert(movie));
       }
       return movieDtoList;
   }

}
