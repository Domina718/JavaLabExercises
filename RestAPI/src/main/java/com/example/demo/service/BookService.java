package com.example.demo.service;

import com.example.demo.dto.BookDTO;

import java.util.List;

public interface BookService {

    void addNew(BookDTO bookDTO) throws Exception;

    List<BookDTO> getAll() throws Exception;

    BookDTO getOne(Long id) throws Exception;

    void delete(Long id);

    void deleteThis (Long id) throws Exception;

    BookDTO updatePartially(Long id, BookDTO bookDTO) throws Exception;
    BookDTO updateWhole(Long id, BookDTO bookDTO) throws Exception;
}