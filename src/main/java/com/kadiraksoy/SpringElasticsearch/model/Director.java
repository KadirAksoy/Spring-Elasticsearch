package com.kadiraksoy.SpringElasticsearch.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Director implements Serializable {

    @NonNull
    private String name;
    private List<Movie> movies;

}
