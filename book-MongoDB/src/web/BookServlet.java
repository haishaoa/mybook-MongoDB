package web;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import pojo.Book;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author haishao
 * @create 2020-05-20 20:19
 * @discript :
 */
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    //插入图书
    protected void insertbook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        bookService = new BookServiceImpl();
        bookService.insert(bookname,booktype,booksalary,bookstock,vip);

        //调用service中的find()方法
        List list = bookService.find();

        //将数据绑定到request的对象上
        req.setAttribute("booklist",list);

        //跳转到展示页面
        req.getRequestDispatcher("book.jsp").forward(req,resp);
    }

    //删除书籍
    protected void delbook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设定字符集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //获取超链接传递过来的属性值
        int createOrderNum = Integer.parseInt(req.getParameter("createOrderNum"));

        //连接数据
        MongoDatabase mongoDatabase = JDBCUtils.getComMongodb();
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("book");

        //执行删除语句
        mongoCollection.deleteOne(Filters.eq("图书编号",createOrderNum));

//        调用service中的find()方法
        bookService = new BookServiceImpl();
        List list = bookService.find();

//        将数据绑定到request的对象上
        req.setAttribute("booklist",list);

        //跳转页面
        //跳转到展示页面
//        req.getRequestDisp
//        atcher("book.jsp").forward(req,resp);
        //重定位方法
//        resp.sendRedirect("book.jsp");

        req.getRequestDispatcher("book.jsp").forward(req,resp);
    }

    //修改书籍
    protected void changebook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //获取前端输入信息
        String bookname = req.getParameter("bookname");
        String booktype = req.getParameter("booktype");
        int booksalary = Integer.parseInt(req.getParameter("booksalary"));
        int bookstock = Integer.parseInt(req.getParameter("bookstock"));
        String vip = req.getParameter("vip");
        String time = req.getParameter("time");

        //调用service中的update()方法
        bookService.update(bookname,booktype,booksalary,bookstock,vip,time);

        //调用service中的find()方法
        bookService = new BookServiceImpl();
        List list = bookService.find();

//        将数据绑定到request的对象上
        req.setAttribute("booklist",list);


        //跳转页面
        req.getRequestDispatcher("book.jsp").forward(req,resp);
    }

    //查找全部书籍
    protected void findbook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //2.调用BookService中的find方法
        List<Book> list = bookService.find();

        //3.返回数据，跳转页面
        req.setAttribute("booklist",list);
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
