package persistencia.repository;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import persistencia.entity.Book;

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
            @Result(property = "title", column = "title"),
            @Result(property = "author", column = "author"),
            @Result(property = "type", column = "type")
    })
    public Optional<Book> getBookById(Integer id);

    @Insert("INSERT INTO book(id,title,author,type) VALUES (#{id},#{title},#{author},#{type})")
    public Book insertBook(Book book);

    @Delete("DELETE book WHERE id = #{id}")
    public Book deleteBookById(Integer id);


}
