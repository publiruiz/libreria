package com.libreria.libreria.service;

import com.libreria.libreria.persistencia.entity.Book;
import com.libreria.libreria.persistencia.entity.User;
import com.libreria.libreria.persistencia.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Transactional
    public List<Book> getBooksForUser(Integer idUser){

        return itemRepository.getBooksByUserId(idUser);
    }
    @Transactional
    public void createdItem(Integer id_book,Integer id_user,Boolean status){

        itemRepository.insertItem(id_book,id_user,status);
    }
    @Transactional
    public void updateStatusFalse(Integer id_item){

        itemRepository.updateStatusFalse(id_item);
    }
    @Transactional
    public List<User> getUserByBookId(Integer id_book){

        return itemRepository.getUserByBookId(id_book);
    }
}
