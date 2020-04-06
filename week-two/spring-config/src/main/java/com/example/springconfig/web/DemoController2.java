package com.example.springconfig.web;

import com.example.springconfig.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController2 {
    @Autowired
    private Book book;

    @GetMapping("/book")
    public String getBook(){

        return book.toString();
    }
}
