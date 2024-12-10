package com.project.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.BookStore.model.Books;

public interface BooksRepository extends JpaRepository <Books, Long> {

}
