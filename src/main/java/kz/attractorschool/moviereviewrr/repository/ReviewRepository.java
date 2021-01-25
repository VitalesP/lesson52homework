package kz.attractorschool.moviereviewrr.repository;

import kz.attractorschool.moviereviewrr.model.Review;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends CrudRepository<Review, String> {
    Optional<Review> findByMovieDirectors(List<String> movie_directors);

    Optional<Review> findByMovieTitle(String title);

    boolean existsByReview(String review);
    @Query("{'title': ?0}")
    Iterable<Review> selectReview(String title);
}
