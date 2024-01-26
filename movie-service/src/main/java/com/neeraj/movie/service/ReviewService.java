package com.neeraj.movie.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.neeraj.movie.entity.Movie;
import com.neeraj.movie.entity.Review;
import com.neeraj.movie.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
    private ReviewRepository repository;
	
	@Autowired
    private MongoTemplate mongoTemplate;
	
	public Review createReview(String reviewBody, String imdbId) {
        Review review = repository.insert(new Review(reviewBody, LocalDateTime.now(), LocalDateTime.now()));

        mongoTemplate.update(Movie.class)
            .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviews").value(review.getId()))
                .first();
        return review;
    }
}
