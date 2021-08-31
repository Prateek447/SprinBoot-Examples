package com.myCodeBook.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.myCodeBook.jpa.dao.MovieRepository;
import com.myCodeBook.jpa.entities.Movie;

@SpringBootApplication
public class SpringbootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext con  =  SpringApplication.run(SpringbootJpaApplication.class, args);
	 
		MovieRepository repo = con.getBean(MovieRepository.class);
		
//		Movie m  = new Movie();
//		m.setMovieName("Intersteller");
//		m.setMovieType("sci-fi");
//		m.setReleaseDate("9/12/2018");
//		repo.save(m);
		
		//update the movie
//		Optional<Movie> option  =  repo.findById(1);
//		Movie movie =  option.get();
//		movie.setMovieName("John Carter");
//		Movie mv = repo.save(movie);
//		System.out.println(mv);
		
		List<Movie> itr= repo.getAllMovies(); 
		itr.forEach(m->{System.out.print(m);});
	}

}
