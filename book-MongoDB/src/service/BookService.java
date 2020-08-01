package service;

import org.bson.Document;
import pojo.Book;

import java.util.List;

/**
 * @author haishao
 * @create 2020-05-18 15:47
 * @discript :
 */
public interface BookService {
    //更新图书信息
    public boolean update(String bookname, String booktype, int booksalary, int bookstock, String vip, String time);

    //根据具体图书名称查询对应的图书信息
    public Book selectBybookname(String bookname);

    //从数据库的book表中查询全部信息
    public List find();

    //将数据插入到数据库的book表
    public void insert(String bookname, String booktype, int booksalary, int bookstock, String vip);
}
