package com.spring.mybits.demo.mapper;

import com.spring.mybits.demo.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MessageMapperTest {
    @Autowired
    private  MessageMapper messageMapper;

    @Test
    @Order(1)
    public  void testInsert(){
//        模拟数据
        Message msg = Message.builder().msgText("#易烊千玺").msgSummary("胖了十斤").build();
        int num = messageMapper.insert(msg);
        log.info("-------->插入的数据数：{}",num);
    }

    @Test
    @Order(2)
    public   void testSelectAll(){
        List<Message> msgs= messageMapper.selectAll();
        if (msgs ==null){
            log.error("msg为null");
        }else {
            msgs.forEach(msg -> log.info("查询到的记录：{}",msg));
        }

    }

    @Test
    @Order(3)
    public  void testSelectById(){
        Message message = messageMapper.selectById(1);
        log.info("id为1的数据：{}",message);
    }

    @Test
    @Order(4)
    public  void testDelete(){
        int num = messageMapper.delete(1);
        log.info("删除的数据条数：{}",num);
    }
    @Test
    @Order(5)
    public void testUpdate(){
        Message message = Message.builder().msgId(1).msgText("易烊千玺")
                .msgSummary("说我没胖").build();
        int num = messageMapper.update(message);
        log.info("更新的数据条数：{}",num);
    }

    @Test
    @Order(6)
    public  void testUpdateText(){
        Message message = Message.builder().msgId(2).msgText("易烊千玺")
                .msgSummary("说我没胖").build();
        int num = messageMapper.updateText(message);
        log.info("更新Text的数据条数:{}",num);
    }
    @Test
    @Order(7)
    public  void testBatchInsert(){
        List<Message> messages = new ArrayList<>(Arrays.asList(
                Message.builder().msgText("肥鹤").msgSummary("那你脸上怎么那么多肉").build(),
                Message.builder().msgText("#易烊千玺").msgSummary("说我没胖").build()));
        int num = messageMapper.batchInsert(messages);
        log.info("插入的数据条数：{}",num);

    }
}