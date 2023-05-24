package com.kadiraksoy.SpringElasticsearch.service;

import com.kadiraksoy.SpringElasticsearch.dto.MovieDto;
import com.kadiraksoy.SpringElasticsearch.dto.converter.MovieDtoConverter;
import com.kadiraksoy.SpringElasticsearch.model.Movie;
import com.kadiraksoy.SpringElasticsearch.repository.MovieRepository;
import org.springframework.data.domain.Page;
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
       List<Movie> movieList = movieRepository.findByName(name);
       List<MovieDto> movieDtoList = new ArrayList<>();

       for (Movie movie : movieList){
           movieDtoList.add(movieDtoConverter.convert(movie));
       }
       return movieDtoList;
   }

   public List<MovieDto> getByRatingInterval(Double start, Double end){
        List<Movie> movieList = movieRepository.findByRatingBetween(start,end);
        List<MovieDto> movieDtoList = new ArrayList<>();

        for(Movie movie : movieList){
            movieDtoList.add(movieDtoConverter.convert(movie));
        }
        return movieDtoList;
   }

    public MovieDto update(String id, MovieDto movieDto) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        optionalMovie.ifPresent(movie -> {
            movie.setId(movieDto.getId());
            movie.setGenre(movieDto.getGenre());
            movie.setName(movieDto.getName());
            movie.setRating(movieDto.getRating());
            movie.setDirector(movieDto.getDirector());
            movieRepository.save(movie);
        });
        return optionalMovie.map(movieDtoConverter::convert).orElse(new MovieDto());

    }

    public void deleteMovie(String id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if(movie.isPresent()) {
            Movie deletedMovie = movie.get();
            movieRepository.delete(deletedMovie);
        }
    }

    public MovieDto saveMovie(MovieDto movieDto){
        Movie tmpMovie = new Movie();
        tmpMovie.setId(movieDto.getId());
        tmpMovie.setName(movieDto.getName());
        tmpMovie.setDirector(movieDto.getDirector());
        tmpMovie.setRating(movieDto.getRating());
        tmpMovie.setGenre(movieDto.getGenre());

        movieRepository.save(tmpMovie);
        return movieDtoConverter.convert(tmpMovie);
    }

    public List<MovieDto> allMovie(){
        List<Movie> movies = (List<Movie>) movieRepository.findAll();
        List<MovieDto> movieDtoList = new ArrayList<>();

        for(Movie movie : movies){
            movieDtoList.add(movieDtoConverter.convert(movie));
        }
        return movieDtoList;
    }

    public Page<MovieDto> searchMovieName(String search) {

        Page<Movie> movies = movieRepository.findByMovieName(search);
        Page<MovieDto> movieDto = movies.map(movieDtoConverter::convert);
        return movieDto;
    }



}
