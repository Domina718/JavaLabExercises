package com.example.demo.controller;

import com.example.demo.dto.BookDTO;
import com.example.demo.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {

    private final BookService bookService;

    public AppController(BookService bookService){
        this.bookService = bookService;
    }


    @PostMapping("/books")
    public ResponseEntity<String> addBook(@RequestBody BookDTO bookDTO){

        bookService.addNew(bookDTO);
        return ResponseEntity.ok("Book successfully added.");
    }

    @GetMapping("/books")
    public ResponseEntity<?> getBooks(){

        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("/books/page/basic")
    public Page<BookDTO> getPagination (@PageableDefault(size=5, sort="title", direction = Sort.Direction.ASC) Pageable pageable){
        return bookService.getAllPagination(pageable);
    }

    @GetMapping("books/sort/{field}")
    public List<BookDTO> sortBooks (@PathVariable String field){
        return bookService.sortByField(field);
    }

    @GetMapping("books/page")
    public Page<BookDTO> sortedPage (@RequestParam (required = false) String title,
                                     @RequestParam (required = false) String author,
                                     @RequestParam (required = false) String genre,
                                     @RequestParam (required = false) Integer yearPublished,
                                     @PageableDefault(size=10, sort = "title", direction = Sort.Direction.ASC) Pageable pageable){
        return bookService.sortPage(title,author,genre,yearPublished, pageable);
    }


    @GetMapping("books/page/new")
    public Page<BookDTO> sortedPage (@RequestParam (required = false) HashMap<String, String> paramsMap,
                                     @PageableDefault(size = 10, sort = "title", direction = Sort.Direction.ASC) Pageable pageable){
        return bookService.sortPageNew(paramsMap, pageable);
    }



    @GetMapping("/books/{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable Long id) {

        return ResponseEntity.ok(bookService.getOne(id));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook (@PathVariable Long id) {

        bookService.deleteThis(id);
        return ResponseEntity.ok("Book deleted successfully.");
    }

    @PatchMapping("/books/{id}")
    public ResponseEntity<?> updateSomeFields (@PathVariable Long id, @RequestBody BookDTO bookDTO) {

        return ResponseEntity.ok(bookService.updatePartially(id, bookDTO));
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateBook (@PathVariable Long id, @RequestBody BookDTO bookDTO) {

        return ResponseEntity.ok(bookService.updateWhole(id, bookDTO));
    }
}
