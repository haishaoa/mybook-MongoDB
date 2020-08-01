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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author haishao
 * @create 2020-05-13 21:34
 * @discript :
 */

@WebServlet(name = "Register", urlPatterns = { "/Register" })
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设定字符编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        // 获取JSP页面传递过来的注册信息包括。用户名。密码。电话等等。。。。。。。
        String Name = req.getParameter("username");
        String password = req.getParameter("password");
        String id = req.getParameter("id");
        System.out.println(Name + "-" + password + "-" + id);
        // 连接数据库设定好要访问的表
        MongoClient mongoClient;
        MongoDatabase mongoDatabse;
        MongoCollection<Document> mongoCollection;
        Document document;

        //访问表工具
        MongoCursor<Document> mongoCursor;
        FindIterable<Document> findIterable;

        MongoDatabase con = JDBCUtils.getComMongodb();
        mongoCollection = con.getCollection("user");

        //获取输出流
        PrintWriter out = resp.getWriter();

        //调用访问的表
        mongoCollection = con.getCollection("user");

        //调用find()进行查询user表中的全部数据,获取迭代器
        findIterable = mongoCollection.find();

        //将迭代出来的内容放入游标挨个遍历
        mongoCursor = findIterable.iterator();

        //创建存放用户的数组
        List<User> list = new ArrayList<>();

        //设置用户名是否存在
        boolean falg = false;

        //循环数据,对比是否在表中有此用户名
        while (mongoCursor.hasNext()){
            User user = new User();
            document = mongoCursor.next();

            //将查询出的结果,保存到pojo对象中,并存于list集合
            //挨个对比是否用户名已存在
            user.setUsername(document.getString("姓名"));
            list.add(user);
        }

        //循环判断是否存在
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(Name)){
                falg = true;
            }
        }

        if (falg){
            out.print("此用户名已被占用");
        }else {
            // 执行插入工作参数 List<? extends Document>
            // new Document("Name", Name) -> "Name"对应表中的字段名 Name对应获取到的变量名
            document = new Document("姓名", Name).append("学号", id).append("密码", password);
            List<Document> documents = new ArrayList<>();
            documents.add(document);
            mongoCollection.insertMany(documents);
            // 跳转到登录页面
//        resp.sendRedirect("/swzl/login.jsp");
            out.print("注册成功");
        }
    }

}
