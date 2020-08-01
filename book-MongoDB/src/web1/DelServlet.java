package web1;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author haishao
 * @create 2020-05-18 22:28
 * @discript :
 */
@WebServlet(name = "DelServlet")
public class DelServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        BookService bookService = new BookServiceImpl();
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
}
