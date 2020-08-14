package io.naren.moviecatalogservice.resources;

import io.naren.moviecatalogservice.model.CatalogItems;
import io.naren.moviecatalogservice.model.Movie;
import io.naren.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItems> getCatalog(@PathVariable String userId){

        List<Rating> ratings = Arrays.asList(
                new Rating("1000", 9),
                new Rating("1001", 8)
        );


     return ratings.stream().map( rating -> {

        Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
        return new CatalogItems(movie.getName(), movie.getDesc(), rating.getRating());

    }).collect(Collectors.toList());

    }


}
