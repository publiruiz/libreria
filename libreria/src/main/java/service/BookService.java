package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import persistencia.entity.Book;
import persistencia.repository.BookRepository;

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
    public Optional<Book> getBookById(long id){
        return bookRepository.getBookById(id);
    }
    @Transactional
    public Book insertBook(Book book){
        return bookRepository.insertBook(book);
    }
    @Transactional
    public Book deleteBook(long id){
        return bookRepository.deleteBookById(id);
    }
}
