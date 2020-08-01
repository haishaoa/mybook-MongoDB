package service.impl;

import dao.ReaderDao;
import dao.impl.ReaderDaoImpl;
import pojo.Book;
import pojo.Reader;
import service.ReaderService;

import java.util.List;

/**
 * @author haishao
 * @create 2020-05-20 1:26
 * @discript :
 */
public class ReaderServiceImpl implements ReaderService {
    private ReaderDao readerDao = new ReaderDaoImpl();

    //更新对应读者信息
    @Override
    public boolean update(String readername, String vip, String phone, String credit) {
        return readerDao.update(readername,vip,phone,credit);
    }

    //根据形参名查找对应读者信息
    @Override
    public Reader selectBybookname(String readername) {
        return readerDao.selectBybookname(readername);
    }

    //查找全部读者信息
    @Override
    public List find() {
        return readerDao.find();
    }

    //插入读者信息
    @Override
    public void insert(String readername, String vip, String phone, String credit) {
        readerDao.insert(readername,vip,phone,credit);
    }
}
