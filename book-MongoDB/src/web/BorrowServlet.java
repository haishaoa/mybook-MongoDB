package web;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import pojo.Borrow;
import service.BorrowService;
import service.impl.BorrowServiceImpl;
import utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author haishao
 * @create 2020-05-20 21:57
 * @discript :
 */
public class BorrowServlet extends BaseServlet {
    private BorrowService borrowService = new BorrowServiceImpl();

    //通过读者名查找借阅记录
    public Borrow selectByReadername(String readername){
        return borrowService.selectByreadername(readername);
    }

    //更新借阅记录
    protected void updateborrow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //2.获取前端页面信息
        int number = Integer.parseInt(req.getParameter("number"));
        String readername = req.getParameter("readername");
        String bookname = req.getParameter("bookname");
        String borrowtime = req.getParameter("borrowtime");

        //3.调用更新方法
        borrowService.update(number,readername,bookname,borrowtime);

        //4.跳转页面
        resp.sendRedirect("borrow.jsp");
    }

    //查找全部的借阅信息
    public List find(){
        return borrowService.find();
    }

    //删除节约记录
    protected void delborrow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    //插入借阅记录
    protected void insertborrow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //2.获取前端传递信息
        String readername = req.getParameter("readername");
        String bookname = req.getParameter("bookname");

        //获取随机时间和操作编号
        int createOrderNum = BorrowServlet.CreateOrderNum();
        String creteData = BorrowServlet.CreteData();

        //3.调用service中插入方法
        borrowService.insert(createOrderNum,readername,bookname,creteData);

        //4.跳转页面
        resp.sendRedirect("borrow.jsp");
    }

    //获取时间
    public static String CreteData(){
        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date date = new Date();

        String time = simpleDateFormat.format(date);

        return time;
    }

    //获取操作编号
    public static int CreateOrderNum(){

        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("MMdd");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        Random random = new Random();

        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

        return Integer.parseInt(rannum + str);// 当前时间

    }
}
