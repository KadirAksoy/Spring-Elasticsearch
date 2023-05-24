package com.kadiraksoy.SpringElasticsearch.model;

import lombok.*;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class Genre implements Serializable {

    @NonNull
    private String name;
}
