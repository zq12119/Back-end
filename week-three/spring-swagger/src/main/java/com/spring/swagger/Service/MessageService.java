package com.spring.swagger.Service;
import com.spring.swagger.exception.CustomException;
import com.spring.swagger.pojo.Message;
import java.util.List;

public interface MessageService {
    List<Message> findAll();
    Message findOne(Long id);
    Message save(Message message) throws CustomException;
    void delete(Long id);
    Message update(Message message) throws CustomException;
    Message updateText(Message message) throws CustomException;
}
