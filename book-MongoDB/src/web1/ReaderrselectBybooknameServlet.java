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

/**
 * @author haishao
 * @create 2020-05-20 3:02
 * @discript :
 */
@WebServlet(name = "ReaderrselectBybooknameServlet")
public class ReaderrselectBybooknameServlet extends HttpServlet {
    private ReaderService readerService = new ReaderServiceImpl();

    public Reader selectByReadername(String readername){
        return readerService.selectBybookname(readername);
    }
}
