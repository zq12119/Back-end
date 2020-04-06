package com.restful.demo.pojo;
import lombok.Data;
import lombok.NonNull;

@Data
public class Message {
    private Long id;
    @NonNull
    private String text;
    private String summary;
}
