package com.jcdk.demo3.repository.impl;

import com.jcdk.demo3.pojo.Message;
import com.jcdk.demo3.repository.MeaasgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MessageRepositoryImpl implements MeaasgeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

   @Override
    public List<Message> findAll() {
        return jdbcTemplate.query("select * from message",
                (rs,rowNum)-> Message.builder()
                        .msgId(rs.getInt("msg_id"))
                        .msgText(rs.getString("msg_text"))
                        .msgSummary(rs.getString("msg_summary"))
                        .build());
    }

    @Override
    public Message findById(Integer id) {
        return jdbcTemplate.queryForObject("select * from message where msg_id=?",
                new Object[] {id},Message.class);
    }

    @Override
    public int insert(Message message) {
        return jdbcTemplate.update("insert into message(msg_text,msg_summary) values(?,?)",
                message.getMsgText(),message.getMsgSummary());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("delete from message where msg_id=?",id);

    }

    @Override
    public int update(Message message) {
        return jdbcTemplate.update("update message set msg_text?,msg_summary=? where msg_id=?",
                message.getMsgText(),message.getMsgSummary(),message.getMsgId());
    }

    @Override
    public int updateText(Message message) {
        return jdbcTemplate.update("update message set msg_text=? where msg_id=?",
                message.getMsgText(),message.getMsgId());
    }

    @Override
    public int[] batchInsert(List<Message> messages) {
        return jdbcTemplate.batchUpdate("insert into message(msg_text,msg_summary) values(?,?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1,messages.get(i).getMsgText());
                        ps.setString(2,messages.get(i).getMsgSummary());
                    }

                    @Override
                    public int getBatchSize() {
                        return messages.size();
                    }
                });
    }
}
