package web1;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import service.ReaderService;
import service.impl.ReaderServiceImpl;
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
 * @create 2020-05-20 3:33
 * @discript :
 */
@WebServlet(name = "DelReaderServlet",urlPatterns = {"/DelReaderServlet"})
public class DelReaderServlet extends HttpServlet {
    private ReaderService readerService = new ReaderServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设定字符集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //2.获取超链接传递过来的属性值
        String readername = req.getParameter("readername");

        //3.连接数据库
        MongoDatabase mongoDatabase = JDBCUtils.getComMongodb();
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("ReaderServlet");

        //4.执行删除语句
        mongoCollection.deleteOne(Filters.eq("读者姓名",readername));

        List list = readerService.find();
        req.setAttribute("list",list);

        //5.跳转页面
        req.getRequestDispatcher("ReaderServlet.jsp").forward(req,resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
