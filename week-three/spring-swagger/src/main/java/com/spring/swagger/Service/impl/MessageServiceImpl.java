package com.spring.swagger.Service.impl;

import com.spring.swagger.Service.MessageService;
import com.spring.swagger.exception.CustomException;
import com.spring.swagger.pojo.Message;

import com.spring.swagger.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository repository;

    @Override
    public List<Message> findAll() {
        return repository.findAll();
    }

    @Override
    public Message findOne(Long id) {
        return (Message) repository.findOne(id);
    }

    @Override
    public Message save(Message message) throws CustomException {
        return repository.save(message);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Message update(Message message) throws CustomException {
        return repository.update(message);
    }

    @Override
    public Message updateText(Message message) throws CustomException {
        return repository.updateText(message);
    }
}
