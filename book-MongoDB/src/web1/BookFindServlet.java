package web1;

import pojo.Book;
import service.BookService;
import service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author haishao
 * @create 2020-05-20 17:19
 * @discript :
 */
@WebServlet(name = "BookFindServlet",urlPatterns = {"/BookFindServlet"})
public class BookFindServlet extends HttpServlet {
    private BookService bookService = new BookServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
