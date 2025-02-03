package com.example.demo.service;

import com.example.demo.dto.BookDTO;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.InvalidRequestException;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.util.Mapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl (BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public void addNew(BookDTO bookDTO) {
        if (bookDTO.getId() != null){
            throw new InvalidRequestException("ID must not be provided for a new book.");
        }
        bookRepository.save(Mapper.bookDTOToBook(bookDTO));
    }

    @Override
    public List<BookDTO> getAll() {
        List<Book> books = bookRepository.findAll();
        if(books.isEmpty()) {
            throw new BookNotFoundException("No books saved.");
        }

        return Mapper.booksToBookDTOs(books);
    }

    @Override
    public BookDTO getOne(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) {
            throw new BookNotFoundException("Book with ID " + id + " does not exist.");
        }
        return Mapper.bookToBookDTO(optionalBook.get());
    }

    @Override
    public void delete(Long id) {

        if(!bookRepository.existsById(id)){
            throw new BookNotFoundException("Book with ID " + id + " does not exist.");
        }
        else {
            bookRepository.deleteById(id);
        }
    }

    @Override
    public void deleteThis (Long id) {
        if(bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
        else{
            throw new BookNotFoundException("Book with ID " + id + " does not exists.");
        }
    }

    @Override
    public BookDTO updatePartially(Long id, BookDTO bookDTO) {

        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isEmpty()){
            throw new BookNotFoundException("Book with ID " + id + " does not exist.");
        }

        BookDTO updatedBookDTO = Mapper.bookToBookDTO(optionalBook.get());
        if(bookDTO.getAuthor() != null){
            updatedBookDTO.setAuthor(bookDTO.getAuthor());
        }
        if(bookDTO.getGenre() != null){
            updatedBookDTO.setGenre(bookDTO.getGenre());
        }
        if(bookDTO.getPublisher() != null){
            updatedBookDTO.setPublisher(bookDTO.getPublisher());
        }
        if(bookDTO.getTitle() != null){
            updatedBookDTO.setTitle(bookDTO.getTitle());
        }
        if(bookDTO.getYearPublished() != null){
            updatedBookDTO.setYearPublished(bookDTO.getYearPublished());
        }
        if(bookDTO.getNumPages() != null){
                updatedBookDTO.setNumPages(bookDTO.getNumPages());
        }

        bookRepository.save(Mapper.bookDTOToBook(updatedBookDTO));
        return updatedBookDTO;
    }

    @Override
    public BookDTO updateWhole(Long id, BookDTO bookDTO) {
        if(!bookRepository.existsById(id)){
            throw new BookNotFoundException("Cannot update - book with ID " + id + " does not exist.");
        }

        if (!id.equals(bookDTO.getId()) && bookDTO.getId() != null) {
            throw new InvalidRequestException("Path ID and Book ID must match.");
        }


        BookDTO updatedBookDTO = new BookDTO();

        if (bookDTO.getAuthor() == null){
            throw new InvalidRequestException("Author field missing.");
        }
        if (bookDTO.getPublisher() == null){
            throw new InvalidRequestException("Publisher field missing.");
        }
        if (bookDTO.getGenre() == null){
            throw new InvalidRequestException("Genre field missing.");
        }
        if (bookDTO.getTitle() == null){
            throw new InvalidRequestException("Title field missing.");
        }
        if (bookDTO.getYearPublished() == null){
            throw new InvalidRequestException("YearPublished field missing.");
        }
        if (bookDTO.getNumPages() == null){
            throw new InvalidRequestException("NumPages field missing.");
        }

        updatedBookDTO.setId(id);
        updatedBookDTO.setAuthor(bookDTO.getAuthor());
        updatedBookDTO.setGenre(bookDTO.getGenre());
        updatedBookDTO.setPublisher(bookDTO.getPublisher());
        updatedBookDTO.setTitle(bookDTO.getTitle());
        updatedBookDTO.setYearPublished(bookDTO.getYearPublished());
        updatedBookDTO.setNumPages(bookDTO.getNumPages());

        bookRepository.save(Mapper.bookDTOToBook(updatedBookDTO));

        return updatedBookDTO;
    }

    @Override
    public List<BookDTO> sortByField(String field){
        return Mapper.booksToBookDTOs(bookRepository.findAll(Sort.by(Sort.Direction.DESC, field)));
    }

    @Override
    public Page<BookDTO> getAllPagination (Pageable pageable){
        return Mapper.booksPagetoBookDTOsPage(bookRepository.findAll(pageable));
    }

    @Override
    public Page<BookDTO> sortPage(String title, String author, String genre, Integer yearPublished, Pageable pageable){
        return Mapper.booksPagetoBookDTOsPage(bookRepository.findByFilters(title, author, genre, yearPublished, pageable));
    }

    @Override
    public Page<BookDTO> sortPageNew(HashMap<String, String> paramsMap, Pageable pageable){
        Integer yearPublished;
        if (paramsMap.get("yearPublished") == null){
            yearPublished = null;
        }
        else{
            yearPublished = parseInt(paramsMap.get("yearPublished"));
        }
        return Mapper.booksPagetoBookDTOsPage(bookRepository.findByFilters(paramsMap.get("title"),
                paramsMap.get("author"), paramsMap.get("genre"), yearPublished, pageable));
    }

    @Override
    public void setStatus (Long id){


    }

}
