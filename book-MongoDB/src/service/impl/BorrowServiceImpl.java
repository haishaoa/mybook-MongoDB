package service.impl;

import dao.BorrowDao;
import dao.impl.BorrowDaoImpl;
import pojo.Borrow;
import service.BorrowService;

import java.util.List;

/**
 * @author haishao
 * @create 2020-05-20 10:47
 * @discript :
 */
public class BorrowServiceImpl implements BorrowService {
    private BorrowDao borrowDao = new BorrowDaoImpl();

    @Override
    public boolean update(int number, String readername, String bookname, String time) {
        return borrowDao.update(number,readername,bookname,time);
    }

    @Override
    public Borrow selectByreadername(String readername) {

        return borrowDao.selectByreadername(readername);
    }

    @Override
    public List find() {
        return borrowDao.find();
    }

    @Override
    public void insert(int number, String readername, String bookname, String time) {
        borrowDao.insert(number,readername,bookname,time);
    }
}
