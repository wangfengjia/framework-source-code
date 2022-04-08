package com.springboot.www.service.impl;


import com.springboot.www.domain.Book;
import com.springboot.www.mapper.BookMapper;
import com.springboot.www.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book getById(Integer id) {
        return bookMapper.selectById(id);
    }
}
