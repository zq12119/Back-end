package com.spring.swagger.repository.impl;

import com.spring.swagger.pojo.Message;
import com.spring.swagger.repository.MessageRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class MessageRepositoryImpl implements MessageRepository {
//    生成id
    private static AtomicLong counter=new AtomicLong();
//    存储Message的数据
    private final ConcurrentHashMap<Long, Message> msgs = new ConcurrentHashMap<>();

    @Override
    public List<Message> findAll() {
        return new ArrayList<>(this.msgs.values());
    }

    @Override
    public Message findOne(Long id) {
        return this.msgs.get(id);
    }

    @Override
    public void delete(Long id) {
        this.msgs.remove(id);
    }

    @Override
    public Message updateText(Message message) {
        Message msg = this.msgs.get(message.getId());
        msg.setText(message.getText());
        this.msgs.put(msg.getId(), msg);
        return msg;
    }

    @Override
    public Message update(Message message) {
        this.msgs.put(message.getId(), message);
        return message;
    }

    @Override
    public Message save(Message message) {
        Long id = message.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            message.setId(id);
        }
        this.msgs.put(id, message);
        return message;
    }
}
