package com.libreria.libreria.persistencia.repository;

import com.libreria.libreria.persistencia.entity.Book;
import com.libreria.libreria.persistencia.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ItemRepository {

    @Insert("INSERT INTO item (id_book, id_user, status) VALUE (#{idBook},#{idUser},#{status},) ")
     void insertItem(Integer id_book,Integer id_user,Boolean status);

    @Select("SELECT id_book FROM item WHERE id_user = #{idUser}")
     List<Book> getBooksByUserId(Integer idUser);

    @Select("SELECT id_user FROM item WHERE id_book = #{idBook}")
     List<User> getUserByBookId(Integer idBook);

    @Update("UPDATE item WHERE id_item = #{id_item} SET status = false")
     void updateStatusFalse(Integer id_item);

}