package web;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import pojo.Reader;
import service.ReaderService;
import service.impl.ReaderServiceImpl;
import utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author haishao
 * @create 2020-05-20 21:13
 * @discript :
 */
public class ReaderServlet extends BaseServlet {
    private ReaderService readerService = new ReaderServiceImpl();

    //通过
    public Reader selectByReadername(String readername){
        return readerService.selectBybookname(readername);
    }

    //删除读者信息
    protected void delreader(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设定字符集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //2.获取超链接传递过来的属性值
        String readername = req.getParameter("readername");

        //3.连接数据库
        MongoDatabase mongoDatabase = JDBCUtils.getComMongodb();
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("reader");

        //4.执行删除语句
        mongoCollection.deleteOne(Filters.eq("读者姓名",readername));

        List list = readerService.find();
        req.setAttribute("list",list);

        //5.跳转页面
        req.getRequestDispatcher("reader.jsp").forward(req,resp);
    }

    //修改读者信息
    protected void updatereader(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        req.getRequestDispatcher("reader.jsp").forward(req,resp);
    }

    //插入读者
    protected void insertreader(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //2.获取前端输入信息
        String readername = req.getParameter("readername");
        String vip = req.getParameter("vip");
        String phone = req.getParameter("phone");
        String credit = req.getParameter("credit");

        //3.调用service中的insert()方法
        readerService.insert(readername,vip,phone,credit);

        List list = readerService.find();
        req.setAttribute("list",list);

        //4.跳转到展示页面
        req.getRequestDispatcher("reader.jsp").forward(req,resp);
    }

    //查找全部读者
    protected void findreader(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //2.调用ReaderService中的find方法返回全部reader的信息
        List<Reader> list = readerService.find();

        //3.返回值，跳转页面
        req.setAttribute("list",list);
        req.getRequestDispatcher("reader.jsp").forward(req,resp);
    }

    //查找全部读者的方法
    public List find(){
        return readerService.find();
    }
}
