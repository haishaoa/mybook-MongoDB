package dao;

import pojo.Book;
import pojo.Reader;

import java.util.List;

/**
 * @author haishao
 * @create 2020-05-20 1:10
 * @discript :
 */
public interface ReaderDao {
    //更新读者信息
    public boolean update(String readername, String vip, String phone, String credit);

    //根据具体读者姓名查询对应的读者信息
    public Reader selectBybookname(String readername);

    //查询出数据库中的读者信息,返回信息
    public List find();

    //数据库的插入reader表
    public void insert(String readername, String vip, String phone, String credit);
}
