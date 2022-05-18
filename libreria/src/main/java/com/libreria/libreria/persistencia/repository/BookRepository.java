package com.libreria.libreria.persistencia.repository;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.libreria.libreria.persistencia.entity.Book;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface BookRepository {

    @Select("SELECT * FROM book")
    @ResultMap("book")
    public List<Book> getAllBook();

    @Select("SELECT * FROM book WHERE id = #{id}")
    @Results(id = "book", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "titulo", column = "title"),
            @Result(property = "autor", column = "author"),
            @Result(property = "genero", column = "type")
    })
    public Optional<Book> getBookById(Integer id);

    @Insert("INSERT INTO book(id,title,author,type) VALUES (#{id},#{titulo},#{autor},#{genero})")
    public void insertBook(Book book);


    @Delete("DELETE FROM book WHERE id = #{id}")
    Book deleteBookById(Long id);

    /*@Delete("delete from t_author where id = #{id}")
    int delete(Long id);*/

}
