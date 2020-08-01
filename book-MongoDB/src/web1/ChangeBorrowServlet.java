package web1;

import service.BorrowService;
import service.impl.BorrowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author haishao
 * @create 2020-05-20 11:37
 * @discript :
 */
@WebServlet(name = "ChangeBorrowServlet",urlPatterns = {"/ChangeBorrowServlet"})
public class ChangeBorrowServlet extends HttpServlet {
    private BorrowService borrowService = new BorrowServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
