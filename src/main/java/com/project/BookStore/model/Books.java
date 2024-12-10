package com.project.BookStore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String bookName;
	private String authorName;
	private Long quantity;
	private Long publishedYear;
	private Long price;
	
	
	public Books() {
		
	}

	public Books(String bookName, String authorName, Long quantity, Long publishedYear, Long price) {
		this.bookName = bookName;
		this.authorName = authorName;
		this.quantity = quantity;
		this.publishedYear = publishedYear;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(Long publishedYear) {
		this.publishedYear = publishedYear;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
}
