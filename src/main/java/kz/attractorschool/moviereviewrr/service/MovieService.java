package kz.attractorschool.moviereviewrr.service;

import kz.attractorschool.moviereviewrr.model.Movie;
import kz.attractorschool.moviereviewrr.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;


    public void sortAndPageable(){
        Sort sortBy = Sort.by(Sort.Order.asc("title"), Sort.Order.asc("rating"));
        int page = 1;
        int count = 10;

        Pageable pageable = PageRequest.of(page, count, sortBy);
        Page<Movie> result = movieRepository.findAll(pageable);
    }

}

