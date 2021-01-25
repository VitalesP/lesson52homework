package kz.attractorschool.moviereviewrr.model;

import kz.attractorschool.moviereviewrr.util.Generator;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;
import java.util.UUID;

@Data
@Document(collection="reviews")
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Review {

    private static final Random r = new Random();

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private int stars;

    private String review;

    @DBRef
    private User reviewer;

    @DBRef
    private Movie movie;

    public static Review random(User reviewer, Movie toMovie) {
        return builder()
                .reviewer(reviewer)
                .movie(toMovie)
                .review(Generator.makeDescription())
                .stars(r.nextInt(5)+1)
                .build();
    }
}
