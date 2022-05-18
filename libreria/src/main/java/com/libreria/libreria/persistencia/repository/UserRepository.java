package com.libreria.libreria.persistencia.repository;

import com.libreria.libreria.persistencia.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface UserRepository {

    @Select("SELECT * FROM user")
    @ResultMap("user")
    public List<User> getAllUser();

    @Insert("INSERT INTO user(id,name,surname,telephone,age,county) " +
            "VALUES (#{id},#{nombre},#{apellidos},#{telefono},#{edad},#{provincia})")
    public void insertUser(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    public void delete(Integer id);

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results(id = "user", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "nombre", column = "name"),
            @Result(property = "apellidos", column = "surname"),
            @Result(property = "telefono", column = "telephone"),
            @Result(property = "edad" , column = "age"),
            @Result(property = "provincia", column = "county")
    })
    public Optional<User> getUserById(Integer id);

    @Update("UPDATE user WHERE id = #{id} SET telephone = #{telephone}")
    public User changeTelefone(User user);
}
