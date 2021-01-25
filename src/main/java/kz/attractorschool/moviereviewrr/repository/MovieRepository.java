package kz.attractorschool.moviereviewrr.repository;

import kz.attractorschool.moviereviewrr.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<Movie, String> {
    //    @Query("{'title': ?0, 'releaseYear': ?1, 'actors': ?2, 'rating': ?3}")
//    Iterable<Movie> selectMovies(String title, String releaseYear, List<String> actors, Double rating);
    Optional<Movie> findByTitle(String title);
    Optional<Movie> findByReleaseYear(String releaseYear);
    Optional<Movie> findByActors(String actors);
    Optional<Movie> findByRating(String rating);



    Page<Movie> findAll(Pageable pageable);
}
