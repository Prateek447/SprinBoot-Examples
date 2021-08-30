package com.myCodeBook.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.myCodeBook.jpa.entities.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
	
	//define own method like this
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
	
	public List<Movie> findByMovieName(String movieName);
	
	//or we can write query using JPQL
	
	@Query("select m FROM Movie m")
	public List<Movie> getAllMovie();
	
	@Query("select m from Movie m where m.id=:id")
	public List<Movie> getMovie(@Param("id") int id);
	
	// or we can write sql native query
	
	@Query(value="select * from Movie", nativeQuery=true)
	public List<Movie> getAllMovies();
	
	

}
