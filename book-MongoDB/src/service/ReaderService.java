package service;

import pojo.Book;
import pojo.Reader;

import java.util.List;

/**
 * @author haishao
 * @create 2020-05-20 1:25
 * @discript :
 */
public interface ReaderService {
    //更新读者信息
    public boolean update(String readername, String vip, String phone, String credit);

    //根据具体读者姓名查询对应的读者信息
    public Reader selectBybookname(String readername);

    //从数据库的Reader表中查询全部信息
    public List find();

    //数据库的插入reader表
    public void insert(String readername, String vip, String phone, String credit);
}
