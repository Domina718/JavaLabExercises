package com.example.demo.repository;


import com.example.demo.model.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    @Query (value = "SELECT b FROM Book b " +
                    "WHERE (:title IS NULL OR :author IS NULL AND b.title LIKE CONCAT('%', :title, '%')) " +
                    "AND (:author IS NULL OR :title IS NULL AND :author = b.author) " +
                    "AND (:genre IS NULL OR b.genre = :genre) " +
                    "AND (:yearPublished IS NULL OR b.yearPublished = :yearPublished) ")
    Page<Book> findByFilters (String title, String author, String genre, Integer yearPublished, Pageable pageable);


}
