package myCodeBook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import myCodeBook.entities.Book;
import myCodeBook.services.BookServices;

@RestController
public class BookController {
	
	
	@Autowired
	private BookServices bookServices;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> list =null;
		try {
			list = bookServices.getAllBooks();
			if(list.size()==0)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book = null;
		try {
			book =  bookServices.getBook(id);
			if(book==null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			return ResponseEntity.of(Optional.of(book));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		try {
			if(book==null)
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			bookServices.addBook(book);
			return ResponseEntity.status(HttpStatus.CREATED).body(book);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int id) {
		this.bookServices.deleteBook(id);
	}
	
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@PathVariable("bookId") int id, @RequestBody Book book) {
		try {
			this.bookServices.updateBook(book, id);
			return ResponseEntity.ok().body(book);
			
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
