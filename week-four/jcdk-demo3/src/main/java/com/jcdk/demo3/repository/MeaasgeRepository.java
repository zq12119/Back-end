package com.jcdk.demo3.repository;

import com.jcdk.demo3.pojo.Message;

import java.util.List;

public interface MeaasgeRepository {
    List<Message> findAll();
    Message findById(Integer id);
    int insert(Message message);
    int delete(Integer id);
    int update(Message message);
    int updateText(Message message);
    int[] batchInsert(List<Message> messages);
}
