package myCodeBook.services;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import myCodeBook.dao.BookRepository;
import myCodeBook.entities.Book;

//this class should use dao in real world projects
@Component
public class BookServices {
	
	@Autowired
	private BookRepository bookRepo;

//	static List<Book> list  = new ArrayList<>();
//	
//	static {
//		list.add(new Book(3,"Hitman","Parker"));
//		list.add(new Book(5,"Mkae","None"));
//		list.add(new Book(7,"Jd","abx"));
//	}
	
	public List<Book> getAllBooks(){
		List<Book> list =  (List<Book>) bookRepo.findAll();
		return list;
	}
	
	public Book getBook(int id) {	
		Book b =  this.bookRepo.findById(id);
		return b;
	}
	
	public Book addBook(Book b) {
		  Book book = this.bookRepo.save(b);
		  return book;
	}
	
	public void deleteBook(int id) {
	    this.bookRepo.deleteById(id);
	}
	
	
	public void updateBook(Book b, int id) {
		b.setId(id);
	   this.bookRepo.save(b);
	}
}
