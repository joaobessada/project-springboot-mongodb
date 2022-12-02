package com.bessada.workshopmongo.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bessada.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	//https://www.mongodb.com/docs/manual/reference/operator/query/regex/
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }") 
	List<Post> searchTitle(String text);
	List<Post> findByTitleContainingIgnoreCase(String text);
}
