package com.example.demo.service;

import com.example.demo.dto.BookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;

public interface BookService {

    void addNew(BookDTO bookDTO);

    List<BookDTO> getAll();

    BookDTO getOne(Long id);

    void delete(Long id);

    void deleteThis (Long id);

    BookDTO updatePartially(Long id, BookDTO bookDTO);
    BookDTO updateWhole(Long id, BookDTO bookDTO);

    List<BookDTO> sortByField(String field);

    Page<BookDTO> getAllPagination (Pageable pageable);

    Page<BookDTO> sortPage(String title, String author, String genre, Integer yearPublished, Pageable pageable);

    Page<BookDTO> sortPageNew(HashMap<String, String> paramsMap, Pageable pageable);

    void setStatus (Long id);
}
