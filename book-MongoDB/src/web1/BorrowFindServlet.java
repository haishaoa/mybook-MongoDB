package web1;

import service.BorrowService;
import service.impl.BorrowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author haishao
 * @create 2020-05-20 11:18
 * @discript :
 */
@WebServlet(name = "BorrowFindServlet")
public class BorrowFindServlet extends HttpServlet {
    private BorrowService borrowService = new BorrowServiceImpl();

    public List find(){
        return borrowService.find();
    }
}
