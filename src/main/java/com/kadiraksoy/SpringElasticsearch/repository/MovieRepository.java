package com.kadiraksoy.SpringElasticsearch.repository;

import com.kadiraksoy.SpringElasticsearch.model.Movie;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieRepository extends ElasticsearchRepository<Movie, String> {

    List<Movie> findByName(String name);
    List<Movie> findByRatingBetween(Double start, Double end);
}
