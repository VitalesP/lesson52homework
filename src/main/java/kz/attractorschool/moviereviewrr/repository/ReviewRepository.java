package kz.attractorschool.moviereviewrr.repository;

import kz.attractorschool.moviereviewrr.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, String> {

}
