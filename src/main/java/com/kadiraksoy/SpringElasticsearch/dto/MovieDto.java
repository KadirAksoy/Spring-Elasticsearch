package com.kadiraksoy.SpringElasticsearch.dto;

import com.kadiraksoy.SpringElasticsearch.model.Director;
import com.kadiraksoy.SpringElasticsearch.model.Genre;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private String id;
    private String name;
    private List<Genre> genre;
    private Double rating;
    private Director director;
}
