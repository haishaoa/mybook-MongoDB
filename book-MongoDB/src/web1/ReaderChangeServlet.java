package web1;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
 * @create 2020-05-20 3:14
 * @discript :
 */
@WebServlet(name = "ReaderChangeServlet",urlPatterns={"/ReaderChangeServlet"})
public class ReaderChangeServlet extends HttpServlet {
    private ReaderService readerService = new ReaderServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //2.获取前端输入
        String readername = req.getParameter("readername");
        String vip = req.getParameter("vip");
        String phone = req.getParameter("phone");
        String credit = req.getParameter("credit");

        //3.调用修改读者信息的方法
        readerService.update(readername,vip,phone,credit);

        List list = readerService.find();
        req.setAttribute("list",list);

        //4.跳转页面
        req.getRequestDispatcher("ReaderServlet.jsp").forward(req,resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
