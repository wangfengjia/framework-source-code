package com.springboot.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.www.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
