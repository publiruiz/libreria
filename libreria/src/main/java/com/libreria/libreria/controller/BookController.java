package com.libreria.libreria.controller;

import com.libreria.libreria.persistencia.entity.Book;
import com.libreria.libreria.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Optional<Book> getBookById(@PathVariable
                                                  Integer id) {
        try{
            return bookService.getBookById(id);
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
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
    @GetMapping("/title")
    public List<Book> getBookByTitle(
            @RequestParam ("title") String title){
        try{
            System.out.println("entra en controller ");

            return bookService.getBookByTitle(title);

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
    }
    @GetMapping("/type")
    public List<Book> getBookByType(@RequestParam (required = false)String type){
       try{
           return bookService.getBookByType(type);
       }catch (Exception e){
       throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
       }
    }
/*
        @RequestMapping(value = "/new", method = RequestMethod.POST)
        public void create( @RequestBody Book book) {
            bookService.insertBook(book);

        }*/
}
