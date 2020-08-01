package web1;

import pojo.Reader;
import service.ReaderService;
import service.impl.ReaderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author haishao
 * @create 2020-05-20 2:07
 * @discript :
 */
@WebServlet(name = "ReaderFindServlet",urlPatterns = {"/ReaderFindServlet"})
public class ReaderFindServlet extends HttpServlet {
    private ReaderService readerService = new ReaderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //2.调用ReaderService中的find方法返回全部reader的信息
        List<Reader> list = readerService.find();

        //3.返回值，跳转页面
        req.setAttribute("list",list);
        req.getRequestDispatcher("ReaderServlet.jsp").forward(req,resp);
    }

    public List find(){
        return readerService.find();
    }
}









