package com.example.demo.service;

import com.example.demo.dto.BookDTO;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl (BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public void addNew(BookDTO bookDTO) throws Exception{
        if (bookDTO.getId() != null){
            throw new Exception("ID must not be provided for a new book.");
        }
        bookRepository.save(Mapper.bookDTOToBook(bookDTO));
    }

    @Override
    public List<BookDTO> getAll() throws Exception {
        List<Book> books = bookRepository.findAll();
        if(books.isEmpty()) {
            throw new Exception("No books saved.");
        }

        return Mapper.booksToBookDTOs(books);
    }

    @Override
    public BookDTO getOne(Long id) throws Exception {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) {
            throw new Exception("Book with ID " + id + " does not exist");
        }
        return Mapper.bookToBookDTO(optionalBook.get());
    }

    @Override
    public void delete(Long id) {

        if(!bookRepository.existsById(id)){
            throw new RuntimeException("Book with ID " + id + " is not found!");
        }
        else {
            bookRepository.deleteById(id);
        }
    }

    @Override
    public void deleteThis (Long id) throws Exception {
        if(bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
        else{
            throw new Exception("Book with this id doesn't exists");
        }
    }

    @Override
    public BookDTO updatePartially(Long id, BookDTO bookDTO) throws Exception {

        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isEmpty()){
            throw new Exception("Book with ID " + id + " does not exist.");
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
    public BookDTO updateWhole(Long id, BookDTO bookDTO) throws Exception {
        if(!bookRepository.existsById(id)){
            throw new IllegalArgumentException("Cannot update - book with ID " + id + " does not exist.");
        }

        if (!id.equals(bookDTO.getId()) && bookDTO.getId() != null) {
            throw new IllegalArgumentException("Path ID and Book ID must match.");
        }


        BookDTO updatedBookDTO = new BookDTO();

        if (bookDTO.getAuthor() == null){
            throw new Exception("Author field missing.");
        }
        if (bookDTO.getPublisher() == null){
            throw new Exception("Publisher field missing.");
        }
        if (bookDTO.getGenre() == null){
            throw new Exception("Genre field missing.");
        }
        if (bookDTO.getTitle() == null){
            throw new Exception("Title field missing.");
        }
        if (bookDTO.getYearPublished() == null){
            throw new Exception("YearPublished field missing.");
        }
        if (bookDTO.getNumPages() == null){
            throw new Exception("NumPages field missing.");
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

}