package com.weng.provider.dao;


import com.weng.pojo.Books;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface BookMapper {

    int getCounts(String bookName);

    //增加一个Book
    int addBook(Books book);

    //根据id删除一个Book
    int deleteBookById(int id);

    //更新Book
    int updateBook(Books books);

    //根据id查询,返回一个Book
    Books queryBookById(int id);

    //查询全部Book,返回list集合
    List<Books> queryAllBook();

    //根据bookName模糊查询，返回list集合
    List<Books> fuzzyQuery(String bookName, int start, int limit);
}