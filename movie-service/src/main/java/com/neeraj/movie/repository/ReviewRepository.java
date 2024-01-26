package com.neeraj.movie.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.neeraj.movie.entity.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
