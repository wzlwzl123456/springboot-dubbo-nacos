package com.weng.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.weng.pojo.Books;
import com.weng.provider.dao.BookMapper;
import com.weng.serivce.BookService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//@DubboService用来暴露服务
@DubboService
public class BookServiceImpl implements BookService {
    // service调dao层
    @Autowired
    private BookMapper bookMapper;

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public List<Books> fuzzyQuery(String bookName,int curr,int limit) {
        return bookMapper.fuzzyQuery(bookName,limit*(curr-1),limit);
    }
    public int getCounts(String bookName){
        return bookMapper.getCounts(bookName);
    }
}