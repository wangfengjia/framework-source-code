package com.springboot.www.controller;

import com.springboot.www.domain.Book;
import com.springboot.www.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/book")
public class BookController {


    @Autowired
    private IBookService bookService;


    @GetMapping("getById/{id}")
    public Book getById(@PathVariable Integer id){

        return bookService.getById(id);
    }
}
