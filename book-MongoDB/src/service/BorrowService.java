package service;

import pojo.Borrow;

import java.util.List;

/**
 * @author haishao
 * @create 2020-05-20 10:46
 * @discript :
 */
public interface BorrowService {
    //更新借阅信息
    public boolean update(int number, String readername, String bookname, String time);

    //根据读者名称查询对应的借阅信息
    public Borrow selectByreadername(String readername);

    //查询出数据库中的全部借阅信息,返回信息
    public List find();

    //数据库的插入borrow表
    public void insert(int number, String readername, String bookname, String time);
}
