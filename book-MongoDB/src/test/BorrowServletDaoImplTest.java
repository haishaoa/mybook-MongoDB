package test;

import dao.BorrowDao;
import dao.impl.BorrowDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author haishao
 * @create 2020-05-20 10:38
 * @discript :
 */
public class BorrowServletDaoImplTest {
    private BorrowDao brrowDao = new BorrowDaoImpl();

    @Test
    public void update() {
        brrowDao.insert(1,"a","b","c");
    }

    @Test
    public void selectByreadername() {
        System.out.println(brrowDao.selectByreadername("a"));
    }

    @Test
    public void find() {
        System.out.println(brrowDao.find());
    }

    @Test
    public void insert() {
        brrowDao.insert(151,"张三","大话java","5-20");
    }
}