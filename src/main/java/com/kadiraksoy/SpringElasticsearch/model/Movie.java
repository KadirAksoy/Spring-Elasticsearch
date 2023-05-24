package com.kadiraksoy.SpringElasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

public class Movie implements Serializable {

    @Id
    private String id;

    @Field(name = "name",type = FieldType.Text)
    private String name;

    @Field(name = "genre",type = FieldType.Nested)
    private List<Genre> genre;

    @Field(name = "rating",type = FieldType.Double)
    private Double rating;

    @Field(name = "director",type = FieldType.Nested)
    private Director director;
}
