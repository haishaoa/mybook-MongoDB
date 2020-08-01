package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import pojo.Book;
import service.BookService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author haishao
 * @create 2020-05-18 16:30
 * @discript :
 */
public class BookServiceImpl implements BookService {
    public static void main(String[] args) {
        BookServiceImpl bookService = new BookServiceImpl();
        System.out.println(bookService.find());
    }

    @Override
    public boolean update(String bookname, String booktype, int booksalary, int bookstock, String vip, String time) {
        BookDao bookDao = new BookDaoImpl();
        boolean update = bookDao.update(bookname, booktype, booksalary, bookstock, vip, time);
        return update;
    }

    //根据具体图书名称查询对应的图书信息
    @Override
    public Book selectBybookname(String bookname) {
        BookDao bookDao = new BookDaoImpl();
        Book book = bookDao.selectBybookname(bookname);
        return book;
    }

    //查到全部图书信息
    @Override
    public List find() {
        BookDao bookDao = new BookDaoImpl();
        List list = bookDao.find();

        return list;
    }

    @Override
    public void insert(String bookname, String booktype, int booksalary, int bookstock, String vip) {
        //得到格式时间和订单编号
        BookServiceImpl bookServiceImpl = new BookServiceImpl();
        //订单编号
        int createOrderNum = bookServiceImpl.CreateOrderNum();
        //格式时间
        String creteData = bookServiceImpl.CreteData();

        BookDaoImpl bookEnteryDaoImpl = new BookDaoImpl();
        bookEnteryDaoImpl.insert(createOrderNum,bookname,booktype,booksalary,bookstock,vip,creteData);
    }

    //获取时间
    public static String CreteData(){
        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date date = new Date();

        String time = simpleDateFormat.format(date);

        return time;
    }

    //获取订单编号
    public static int CreateOrderNum(){

        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("MMdd");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        Random random = new Random();

        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

        return Integer.parseInt(rannum + str);// 当前时间

    }
}
