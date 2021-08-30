package com.myCodeBook.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String movieName;
	private String releaseDate;
	private String movieType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public Movie(int id, String movieName, String releaseDate, String movieType) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.movieType = movieType;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", releaseDate=" + releaseDate + ", movieType="
				+ movieType + "]";
	}
	
	

}
