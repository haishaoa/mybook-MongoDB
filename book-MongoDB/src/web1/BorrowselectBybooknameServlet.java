package web1;

import pojo.Borrow;
import pojo.Reader;
import service.BorrowService;
import service.impl.BorrowServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author haishao
 * @create 2020-05-20 11:44
 * @discript :
 */
@WebServlet(name = "BorrowselectBybooknameServlet")
public class BorrowselectBybooknameServlet extends HttpServlet {
    private BorrowService borrowService = new BorrowServiceImpl();

    public Borrow selectByReadername(String readername){
        return borrowService.selectByreadername(readername);
    }
}

