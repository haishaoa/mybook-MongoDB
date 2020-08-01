package web1;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import pojo.Book;
import service.BookService;
import service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author haishao
 * @create 2020-05-18 14:48
 * @discript :
 */
@WebServlet(name = "EnteryServlet",urlPatterns = {"/EnteryServlet"})
public class EnteryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //获取前端输入信息
        String bookname = req.getParameter("bookname");
        String booktype = req.getParameter("booktype");
        int booksalary = Integer.parseInt(req.getParameter("booksalary"));
        int bookstock = Integer.parseInt(req.getParameter("bookstock"));
        String vip = req.getParameter("vip");

        //调用insert()方法将数据插入数据库中
        BookService bookService = new BookServiceImpl();
        bookService.insert(bookname,booktype,booksalary,bookstock,vip);

        //调用service中的find()方法
        List list = bookService.find();

        //将数据绑定到request的对象上
        req.setAttribute("booklist",list);

        //跳转到展示页面
        req.getRequestDispatcher("book.jsp").forward(req,resp);
    }

    //查找全部的图书信息
    public List find(){
        BookService bookService = new BookServiceImpl();
        List list = bookService.find();

        return list;
    }

    //查找对应的图书名的全部信息
    public Book selectBybookname(String bookname){

        System.out.println("bookname--->" + bookname);

        BookService bookService = new BookServiceImpl();
        Book book = bookService.selectBybookname(bookname);
        return book;
    }

}























