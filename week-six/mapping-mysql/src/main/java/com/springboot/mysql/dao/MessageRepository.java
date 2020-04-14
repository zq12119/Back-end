package com.springboot.mysql.dao;

import com.springboot.mysql.cascade.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {
    // 解析方法名创建查询
    List<Message> findByMsgSummary(String msgSummary);
    List<Message> findByMsgTextOrMsgSummary(String msgText, String msgSummary);
    List<Message> findByMsgTextLike(String text);
    List<Message> findDistinctByMsgIdLessThan(int maxId);

    // JPQL查询，类似 Hibernate的 HQL语法，在接口上使用 @Query
    @Query("select msgId, msgText, msgSummary from Message where msgId = ?1")
    Message findById(int msgId);
    // 修改
    @Modifying
    @Transactional
    @Query(value = "update message set msg_text = ?1 where msg_id < ?2", nativeQuery = true)
    int updateName(String msgText, int msgId);
    // 分页查询
    @Query("select m from Message m where m.msgSummary=?1")
    public Page<Message> findByName(String msgSummary, Pageable pageable);
    // 插入
    @Transactional
    @Modifying
    @Query(value = "insert into message(msg_text, msg_summary) values(:msgText, :msgSummary)", nativeQuery = true)
    Integer insertMessage(@Param("msgText") String msgText, @Param("msgSummary") String msgSummary);
}

