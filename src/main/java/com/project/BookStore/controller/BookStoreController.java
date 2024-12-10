package com.project.BookStore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.BookStore.model.Books;
import com.project.BookStore.repository.BooksRepository;

@RestController
public class BookStoreController {
	
	@Autowired 
	private BooksRepository booksRepository;
	
	@GetMapping()
	public String welcome() {
		return "Welcome to Book Store : " + "\n" + "\n" + 
				"You can use Postman to test my project:" + "\n" + "\n" + 
				"Get(/api) = to see all data," + "\n" + "\n" + 
				"Get(/api/{id}) = to see unique data," + "\n" +"\n" + 
				"Post(/api) = ' bookName(String), authorName(String), quantity(Long), publishedYear(Long), price(Long) ' - data format to post the data,"+ "\n" + "\n" + 
				"Put(/api/{id}) = to update data," + "\n" + "\n" + 
				"Delete(/api/{id}) = to delete data.";
	}
	
	@GetMapping("api")
	public List<Books> get() {
		return booksRepository.findAll();
	}
	
	@GetMapping("api/{id}")
	public Optional<Books> find(@PathVariable Long id) {
		Optional<Books> find = booksRepository.findById(id);
		if(find.isPresent()) {
			return find;
		}
		return find;
	}
	
	@PostMapping()
	public String post(@RequestBody Books b) {
		booksRepository.save(b);
		return "Posted Successfully";
	}
	
	@PutMapping("api/{id}")
	public String put(@PathVariable Long id, @RequestBody Books b) {
		Optional<Books> existingBook = booksRepository.findById(id);
		if(existingBook.isPresent()) {
			Books updatingBook=existingBook.get();
			updatingBook.setBookName(b.getBookName());
	        updatingBook.setAuthorName(b.getAuthorName());
	        updatingBook.setPublishedYear(b.getPublishedYear());
	        updatingBook.setPrice(b.getPrice());
	        booksRepository.save(updatingBook);
			return "Updated Succesfully";
		}
		return "Not Found";
	}
	
	@DeleteMapping("api/{id}")
	public String delete(@PathVariable Long id) {
		if(booksRepository.existsById(id)) {
			booksRepository.deleteById(id);
			return "Deleted Successfully";
		}
		return "Not Found";
	}
}
