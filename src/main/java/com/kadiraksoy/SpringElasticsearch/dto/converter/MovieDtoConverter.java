package com.kadiraksoy.SpringElasticsearch.dto.converter;

import com.kadiraksoy.SpringElasticsearch.dto.MovieDto;
import com.kadiraksoy.SpringElasticsearch.model.Movie;
import org.springframework.stereotype.Component;


@Component
public class MovieDtoConverter {

    public MovieDto convert(Movie movie){
        return new MovieDto(
                movie.getId(),
                movie.getName(),
                movie.getGenre(),
                movie.getRating(),
                movie.getDirector());
    }
}
