package com.libreria.libreria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.libreria.libreria.persistencia.entity.Book;
import com.libreria.libreria.persistencia.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Transactional
    public List<Book> getAllBook(){
        return bookRepository.getAllBook();
    }

    @Transactional
    public Optional<Book> getBookById(Integer id){
        return bookRepository.getBookById(id);
    }

    @Transactional
    public void insertBook(Book book){
         bookRepository.insertBook(book);
    }
    @Transactional
    public Book deleteBook(Long id){
        return bookRepository.deleteBookById(id);
    }
}
