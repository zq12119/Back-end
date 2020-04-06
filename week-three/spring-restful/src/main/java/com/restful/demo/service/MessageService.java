package com.restful.demo.service;

import com.restful.demo.exception.CustomException;
import com.restful.demo.pojo.Message;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MessageService {
    List<Message> findAll();
    Message findOne(Long id);
//    抛出Custom..
    Message save(Message message) throws CustomException;
    void delete(Long id);
    Message update(Message message) throws CustomException;
    Message updateText(Message message) throws CustomException;

}
