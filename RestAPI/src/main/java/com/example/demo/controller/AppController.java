package com.example.demo.controller;

import com.example.demo.dto.BookDTO;
import com.example.demo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AppController {

    private final BookService bookService;

    public AppController(BookService bookService){
        this.bookService = bookService;
    }


    @PostMapping("/books")
    public ResponseEntity<String> addBook(@RequestBody BookDTO bookDTO) throws Exception{
        try{
            bookService.addNew(bookDTO);
        }
        catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Book successfully added.");


    }

    @GetMapping("/books")
    public ResponseEntity<?> getBooks(){
        try{
            return ResponseEntity.ok(bookService.getAll());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok(bookService.getOne(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook (@PathVariable Long id) throws Exception {
        try{
            bookService.deleteThis(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.ok("Book deleted successfully.");
    }

    @PatchMapping("/books/{id}")
    public ResponseEntity<?> updateSome (@PathVariable Long id, @RequestBody BookDTO bookDTO) throws Exception {
        try{
            return ResponseEntity.ok(bookService.updatePartially(id, bookDTO));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateBook (@PathVariable Long id, @RequestBody BookDTO bookDTO) throws Exception {
        try{
            return ResponseEntity.ok(bookService.updateWhole(id, bookDTO));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}