package dao.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import dao.BorrowDao;
import org.bson.Document;
import org.bson.conversions.Bson;
import pojo.Borrow;
import utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haishao
 * @create 2020-05-20 10:20
 * @discript :
 */
public class BorrowDaoImpl implements BorrowDao {
    //修改方法
    @Override
    public boolean update(int number, String readername, String bookname, String time) {
        //获取数据库连接
        MongoDatabase mongoDatabase = JDBCUtils.getComMongodb();
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("borrow");

        //调用更新方法,来更新图书记录

        //获取更新的关键字(要知道是更新哪条记录,否则会全部更新)
        Bson filter = Filters.eq("读者名",readername);

        //Document封装更新的内容
        Document document = new Document("$set",new Document("操作编号",number).append("读者名",readername).append("借阅书籍",bookname).append("借阅时间",time));

        //updateOne()方法一个参数是更新的条件,第二个参数是更新的内容
        mongoCollection.updateOne(filter,document);

        //更新的结果返回
        return true;
    }

    //按读者名查找数据
    @Override
    public Borrow selectByreadername(String readername) {
        //连接数据库
        MongoClient mongoClient;
        MongoDatabase mongoDatabase;
        MongoCollection<Document> mongoCollection;
        Document document;
        FindIterable<Document> findIterable;
        MongoCursor<Document> mongoCursor;

        //连接数据库
        mongoDatabase = JDBCUtils.getComMongodb();
        mongoCollection = mongoDatabase.getCollection("borrow");

        //根据形参进行查询
        BasicDBObject filter_dbobject = new BasicDBObject();
        filter_dbobject.put("读者名",readername);
        findIterable = mongoCollection.find(filter_dbobject);
        mongoCursor = findIterable.iterator();

        //将查询到的记录保存到pojo对象中
        Borrow borrow = new Borrow();
        while (mongoCursor.hasNext()){
            document = (Document) mongoCursor.next();

            borrow.setNumber(document.getInteger("操作编号"));
            borrow.setReadername(document.getString("读者名"));
            borrow.setBookname(document.getString("借阅书籍"));
            borrow.setBorrowtime(document.getString("借阅时间"));
        }

        return borrow;
    }

    //查找全部数据
    @Override
    public List find() {
        //获取数据库连接
        MongoDatabase mongoDatabase = JDBCUtils.getComMongodb();

        //获取borrow表中的数据
        //访问的表borrow
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("borrow");

        //调用find()进行查询borrow表中的全部数据,获取迭代器
        FindIterable<Document> findIterable = mongoCollection.find();

        //将迭代出来的内容放入游标挨个遍历
        MongoCursor mongoCursor= findIterable.iterator();

        //创建存放书籍的数组
        List<Borrow> list = new ArrayList();

        //循环数据,将数据复制给对应的Book对象
        while (mongoCursor.hasNext()){
            Borrow borrow = new Borrow();
            Document document = (Document) mongoCursor.next();

            //赋值
            borrow.setNumber(document.getInteger("操作编号"));
            borrow.setReadername(document.getString("读者名"));
            borrow.setBookname(document.getString("借阅书籍"));
            borrow.setBorrowtime(document.getString("借阅时间"));

            list.add(borrow);
        }

        return list;
    }

    @Override
    public void insert(int number, String readername, String bookname, String borrowtime) {
        //1.连接数据库
        MongoDatabase mongoDatabase = JDBCUtils.getComMongodb();
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("borrow");

        //2.插入数据
        Document document = new Document("操作编号",number).append("读者名",readername).append("借阅书籍",bookname).append("借阅时间",borrowtime);
        List<Document> documents = new ArrayList<>();
        documents.add(document);
        mongoCollection.insertMany(documents);
    }
}














