package com.atguigu.test;

import service.impl.BookServiceImpl;

/**
 * @author haishao
 * @create 2020-05-18 16:50
 * @discript :
 */
public class BookServiceImplTest {

    @org.junit.Test
    public void insert() {
        BookServiceImpl bookServiceImpl = new BookServiceImpl();
        bookServiceImpl.insert("a","b",1,1,"e");
     }

    @org.junit.Test
    public void creteData() {
    }

    @org.junit.Test
    public void createOrderNum() {
    }
}