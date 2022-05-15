package persistencia.repository;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import persistencia.entity.User;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface UserRepository {

    @Select("SELECT * FROM user")
    public List<User> getAllUser();

    @Insert("INSERT INTO user(id,name,surname,telephone,age) VALUES (#{id},#{name},#{surname},#{telephone},#{age})")
    public User insertUser(User user);

    @Delete("DELETE user WHERE id = #{id}")
    public User delete(long id);

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results(id = "user", value = {
            @Result(id=true ,property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "surname", column = "surname"),
            @Result(property = "telephone", column = "telephone"),
            @Result(property = "age" , column = "age")
    })
    public Optional<User> getUserById(long id);

    @Update(" UPDATE user WHERE id = #{id} SET telephone = #{telephone}")
    public User changeTelefone(User user);
}
