package myCodeBook.dao;

import org.springframework.data.repository.CrudRepository;

import myCodeBook.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	
	public Book findById(int id);

}
