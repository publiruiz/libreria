package com.libreria.libreria.controller;

import com.libreria.libreria.persistencia.entity.Book;
import com.libreria.libreria.persistencia.entity.User;
import com.libreria.libreria.service.ItemService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/")
    public List<Book> getBooksForUser(@RequestParam(value = "id_user") Integer idUser){
    try{
        return itemService.getBooksForUser(idUser);
        }catch (Exception e){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @PostMapping("/new")
    public void createdItem(Integer id_book,Integer id_user){
        try{
            itemService.createdItem(id_book,id_user,true);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }
    @Update("/status/{id_item}")
    public void updateStatusFalse(@PathVariable("id_item") Integer id_item){

        itemService.updateStatusFalse(id_item);
    }
    @GetMapping("/{id_book}")
    public List<User> getUserByBookId(@PathVariable("id_book")
                                                  Integer id_book){
        try{
            return itemService.getUserByBookId(id_book);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
