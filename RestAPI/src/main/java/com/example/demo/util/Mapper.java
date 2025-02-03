
package com.example.demo.util;

import com.example.demo.dto.BookDTO;
import com.example.demo.model.Book;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static BookDTO bookToBookDTO (Book book){
        BookDTO bookDTO = new BookDTO();

        bookDTO.setId(book.getId());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setPublisher(book.getPublisher());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setYearPublished(book.getYearPublished());
        bookDTO.setNumPages(book.getNumPages());

        return bookDTO;
    }

    public static Book bookDTOToBook (BookDTO bookDTO){
        Book book = new Book();

        book.setId(bookDTO.getId());
        book.setAuthor(bookDTO.getAuthor());
        book.setGenre(bookDTO.getGenre());
        book.setPublisher(bookDTO.getPublisher());
        book.setTitle(bookDTO.getTitle());
        book.setYearPublished(bookDTO.getYearPublished());
        book.setNumPages(bookDTO.getNumPages());

        return book;
    }

    public static List<BookDTO> booksToBookDTOs (List<Book> books){
        List<BookDTO> bookDTOs = new ArrayList<>();
        for(Book book : books){
            bookDTOs.add(bookToBookDTO(book));
        }

        return bookDTOs;
    }
}
