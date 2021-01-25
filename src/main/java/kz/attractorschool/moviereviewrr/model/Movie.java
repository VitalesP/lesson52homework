package kz.attractorschool.moviereviewrr.model;

import kz.attractorschool.moviereviewrr.util.Generator;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@Data
@Document(collection="movies")
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Movie {

    private static final Random r = new Random();

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String title;
    private String poster;
    private int releaseYear;

    @Builder.Default
    private List<String> directors = new ArrayList<>();

    @Builder.Default
    private List<String> actors = new ArrayList<>();

    // I think rating should be calculated upon adding a review and updated in the document
    // think service layer or even better move to separate consumer to calculate and update (queues)
    private double rating;

    public static Movie random() {
        return builder()
                .title(Generator.makeName())
                .releaseYear(r.nextInt(20)+2000)
                .rating(r.nextInt(500)+1 / 100.0f)
                .actors(Stream.generate(Generator::makeName).limit(r.nextInt(3) + 1).collect(toList()))
                .directors(Stream.generate(Generator::makeName).limit(r.nextInt(1) + 1).collect(toList()))
                .build();
    }
}
