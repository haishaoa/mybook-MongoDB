package web1;

import service.BookService;
import service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.List;

/**
 * @author haishao
 * @create 2020-05-19 16:07
 * @discript :
 */
@WebServlet(name = "ChangeBookServlet",urlPatterns = {"/ChangeBookServlet"})
public class ChangeBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        BookService bookService = new BookServiceImpl();
        bookService.update(bookname,booktype,booksalary,bookstock,vip,time);

        //调用service中的find()方法
        bookService = new BookServiceImpl();
        List list = bookService.find();

//        将数据绑定到request的对象上
        req.setAttribute("booklist",list);


        //跳转页面
        req.getRequestDispatcher("book.jsp").forward(req,resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
