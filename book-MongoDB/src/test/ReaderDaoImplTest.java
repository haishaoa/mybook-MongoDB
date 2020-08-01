package test;

import dao.ReaderDao;
import dao.impl.ReaderDaoImpl;
import org.junit.Test;
import pojo.Reader;

import static org.junit.Assert.*;

/**
 * @author haishao
 * @create 2020-05-20 2:04
 * @discript :
 */
public class ReaderDaoImplTest {
    private ReaderDao readerDao = new ReaderDaoImpl();

    @Test
    public void selectBybookname(){
        System.out.println("执行");
        System.out.println("asmkamd-->" + readerDao.selectBybookname("小夏"));
    }

    @Test
    public void find() {
        System.out.println(readerDao.find());
    }

    @Test
    public void insert() {
    }
}