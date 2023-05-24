package com.kadiraksoy.SpringElasticsearch.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Genre implements Serializable {

    @NonNull
    private String name;
}
