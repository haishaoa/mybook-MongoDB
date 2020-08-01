package dao.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import dao.BookDao;
import org.bson.Document;
import org.bson.conversions.Bson;
import pojo.Book;
import utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haishao
 * @create 2020-05-18 15:05
 * @discript :
 */
public class BookDaoImpl implements BookDao {
    public static void main(String[] args) {
//        BookDaoImpl bookEntery = new BookDaoImpl();
//        List list = bookEntery.find();
//        System.out.println("list:" + list);
        //        Document document = bookEntery.find();
//        System.out.println(document);

        //测试selectBybookname()方法
        BookDao bookDao = new BookDaoImpl();
        System.out.println(((BookDaoImpl) bookDao).selectBybookname("大话java"));
    }

    @Override
    public boolean update(String bookname,String booktype, int booksalary, int bookstock, String vip, String time) {
        //获取数据库连接
        MongoDatabase mongoDatabase = JDBCUtils.getComMongodb();
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("book");

        //调用更新方法,来更新图书记录

        //获取更新的关键字(要知道是更新哪条记录,否则会全部更新)
        Bson filter = Filters.eq("图书名称",bookname);

        //Document封装更新的内容
        Document document = new Document("$set",new Document("图书种类",booktype).append("图书价格",booksalary).append("库存",bookstock).append("是否为vip",vip).append("录入时间",time));

        //updateOne()方法一个参数是更新的条件,第二个参数是更新的内容
        mongoCollection.updateOne(filter,document);

        //更新的结果返回
        return true;
    }

    //查询指定书籍信息
    public Book selectBybookname(String bookname){
        //连接数据库
        MongoClient mongoClient;
        MongoDatabase mongoDatabase;
        MongoCollection<Document> mongoCollection;
        Document document;
        FindIterable<Document> findIterable;
        MongoCursor<Document> mongoCursor;

        //连接数据库
        mongoDatabase = JDBCUtils.getComMongodb();
        mongoCollection = mongoDatabase.getCollection("book");

        //根据形参进行查询
        BasicDBObject filter_dbobject = new BasicDBObject();
        filter_dbobject.put("图书名称",bookname);
        findIterable = mongoCollection.find(filter_dbobject);
        mongoCursor = findIterable.iterator();

        //将查询到的记录保存到pojo对象中
        Book book = new Book();
        while (mongoCursor.hasNext()){
            document = (Document) mongoCursor.next();
            book.setCreateOrderNum(document.getInteger("图书编号"));
            book.setBookname(document.getString("图书名称"));
            book.setBooktype(document.getString("图书种类"));
            book.setBooksalary(document.getInteger("图书价格"));
            book.setBookstock(document.getInteger("库存"));
            book.setVip(document.getString("是否为vip"));
            book.setTime(document.getString("录入时间"));
        }

        return book;
    }

    //查找书籍信息
    @Override
    public List find() {
        //获取数据库连接
        MongoDatabase mongoDatabase = JDBCUtils.getComMongodb();

        //获取book表中的数据
        //访问的表book
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("book");

        //调用find()进行查询book表中的全部数据,获取迭代器
        FindIterable<Document> findIterable = mongoCollection.find();

        //将迭代出来的内容放入游标挨个遍历
        MongoCursor mongoCursor= findIterable.iterator();

        //创建存放书籍的数组
        List<Book> list = new ArrayList();

        //循环数据,将数据复制给对应的Book对象
        while (mongoCursor.hasNext()){
            Book book = new Book();
            Document document = (Document) mongoCursor.next();

            //赋值
            book.setCreateOrderNum(document.getInteger("图书编号"));
            book.setBookname(document.getString("图书名称"));
            book.setBooktype(document.getString("图书种类"));
            book.setBooksalary(document.getInteger("图书价格"));
            book.setBookstock(document.getInteger("库存"));
            book.setVip(document.getString("是否为vip"));
            book.setTime(document.getString("录入时间"));
            list.add(book);
        }

        return list;
    }

    //插入图书信息
    @Override
    public void insert(int createOrderNum, String bookname, String booktype, int booksalary, int bookstock, String vip, String time) {
        MongoClient mongoClient;
        MongoDatabase con;
        MongoCollection<Document> mongoCollection;
        Document document;

        //获取数据库连接
        con = JDBCUtils.getComMongodb();
        mongoCollection = con.getCollection("book");

        document = new Document("图书编号", createOrderNum).append("图书名称", bookname).append("图书种类", booktype).append("图书价格", booksalary).append("库存", bookstock).append("是否为vip", vip).append("录入时间", time);
        List<Document> documents = new ArrayList<>();
        documents.add(document);
        mongoCollection.insertMany(documents);
    }
}
