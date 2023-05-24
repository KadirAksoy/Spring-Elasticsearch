package com.kadiraksoy.SpringElasticsearch.repository;

import com.kadiraksoy.SpringElasticsearch.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieRepository extends ElasticsearchRepository<Movie, String> {

    List<Movie> findByName(String name);
    List<Movie> findByRatingBetween(Double start, Double end);

    @Query("{\"match\": {\"movie\": {\"query\": \"name\"}}}")
    Page<Movie> findByMovieName(String name);
}

//WE CAN WRITE THIS CODE IN MOVIESERVICE CLASS.


//    NativeSearchQuery searchQuery = new NativeSearchQuery()
//            .withQuery(QueryBuilders.matchQuery(Constant.MOVIE_NAME,search))   ---> search = param of function.
//            .build();

//    NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
//            .withQuery(matchQuery(Constants.MOVIE_NAME, search)    ---->  search = param of function
//                    .operator(Operator.AND)
//                    .fuzziness(Fuzziness.AUTO) // change any uppercase or lowercase letter
//                    .prefixLength(3)) // not changed in first 3 letters of search text
//            .build();

//    NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
//            .withQuery(multiMatchQuery(search)                    ---->  search = param of function
//                    .field(Constants.MOVIE_NAME)
//                    .field(Constants.MOVIE_ID)
//                    .type(MultiMatchQueryBuilder.Type.BEST_FIELDS))
//            .build();


//
//    NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
//        .withQuery(matchPhraseQuery(Constants.MOVIE_NAME, search).slop(1))    ---->  search = param of function
//        .build();
//        return movieRepository.search(searchQuery);
//        }