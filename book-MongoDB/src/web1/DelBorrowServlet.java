package web1;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author haishao
 * @create 2020-05-20 11:32
 * @discript :
 */
@WebServlet(name = "DelBorrowServlet",urlPatterns = {"/DelBorrowServlet"})
public class DelBorrowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设定字符集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //2.获取超链接传递过来的属性值
        String readername = req.getParameter("readername");

        //3.连接数据库
        MongoDatabase mongoDatabase = JDBCUtils.getComMongodb();
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("borrow");

        //4.执行删除语句
        mongoCollection.deleteOne(Filters.eq("读者名",readername));

        //5.跳转页面
        resp.sendRedirect("borrow.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
