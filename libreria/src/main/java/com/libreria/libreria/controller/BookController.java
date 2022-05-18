package com.libreria.libreria.controller;

import com.libreria.libreria.persistencia.entity.Book;
import com.libreria.libreria.service.BookService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/all")
    public List<Book> getAllBook() {
        return bookService.getAllBook();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public Book deleteBook(@PathVariable Long id, HttpServletResponse response) {
        return bookService.deleteBook(id);
    }

    @PostMapping("/new")
    public void insertBook(@RequestBody Book book) {

        try {
            bookService.insertBook(book);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
/*
        @RequestMapping(value = "/new", method = RequestMethod.POST)
        public void create( @RequestBody Book book) {
            bookService.insertBook(book);

        }*/
}
