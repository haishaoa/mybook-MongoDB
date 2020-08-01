package web1;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import pojo.User;
import utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author haishao
 * @create 2020-05-12 20:01
 * @discript :
 */
@WebServlet(name = "LoginCheckServlet",urlPatterns = {"/LoginCheckServlet"})
public class LoginCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MongoClient mongoClient;
        MongoDatabase mongoDatabase;
        MongoCollection<Document> mongoCollection;
        FindIterable<Document> findIterable;
        MongoCursor<Document> mongoCursor;

        //设置传入传出编码格式
        req.setCharacterEncoding("utf-8");


        //获取页面传递过来的值username/password
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();
        session.setAttribute("username",username);

        //获取数据库连接
        MongoDatabase con = JDBCUtils.getComMongodb();
        resp.setContentType("text/html;charset=utf-8");

        //获取写出流
        PrintWriter out = resp.getWriter();

        //访问的表
        mongoCollection = con.getCollection("user");

        //调用find()进行查询user表中的全部数据,获取迭代器
        findIterable = mongoCollection.find();

        //将迭代出来的内容放入游标挨个遍历
        mongoCursor = findIterable.iterator();

        //创建存放用户的数组
        List<User> list = new ArrayList<>();

        //设置登录成功的标识
        boolean falg = false;
        System.out.println("5555" + falg);
        //循环数据,对比是否在表中有待登录的用户名
        while (mongoCursor.hasNext()){
            User user = new User();
            Document document = (Document) mongoCursor.next();

            //将查询出的结果,保存到pojo对象中,并存于list集合,
            // 然后挨个对比是否可登录
            user.setUsername(document.getString("姓名"));
            user.setPassword(document.getString("密码"));
            list.add(user);
        }

        //循环判断是否存在
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username) && list.get(i).getPassword().equals(password)){
                falg = true;
                break;
            }
        }
        System.out.println("falg=" + falg);
        if (falg){
//            req.getRequestDispatcher("/Manage.html").forward(req,resp);
            out.print("用户存在");
            System.out.println("******");
        }else {
//            resp.sendRedirect("/swzl/login.jsp");
            out.print("用户不存在");
        }
    }

}





















