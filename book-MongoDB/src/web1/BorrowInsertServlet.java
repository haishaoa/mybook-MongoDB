package web1;

import service.BorrowService;
import service.impl.BorrowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author haishao
 * @create 2020-05-20 11:07
 * @discript :
 */
@WebServlet(name = "BorrowInsertServlet",urlPatterns = {"/BorrowInsertServlet"})
public class BorrowInsertServlet extends HttpServlet {
    private BorrowService borrowService = new BorrowServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //2.获取前端传递信息
        String readername = req.getParameter("readername");
        String bookname = req.getParameter("bookname");

        //获取随机时间和操作编号
        int createOrderNum = BorrowInsertServlet.CreateOrderNum();
        String creteData = BorrowInsertServlet.CreteData();

        //3.调用service中插入方法
        borrowService.insert(createOrderNum,readername,bookname,creteData);

        //4.跳转页面
        resp.sendRedirect("borrow.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
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
