package dao;

import pojo.Book;
import pojo.Borrow;

import java.util.List;

/**
 * @author haishao
 * @create 2020-05-18 15:04
 * @discript :
 */
public interface BookDao {
    //更新图书信息
    public boolean update(String bookname, String booktype, int booksalary, int bookstock, String vip, String time);

    //根据具体图书名称查询对应的图书信息
    public Book selectBybookname(String bookname);

    //查询出数据库中的书籍信息,返回信息
    public List find();

    //数据库的插入book表
    public void insert(int createOrderNum, String bookname, String booktype, int booksalary, int bookstock, String vip, String time);

}
















