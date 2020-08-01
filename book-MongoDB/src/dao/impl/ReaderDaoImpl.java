package dao.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import dao.ReaderDao;
import org.bson.Document;
import org.bson.conversions.Bson;
import pojo.Reader;
import utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haishao
 * @create 2020-05-20 1:10
 * @discript :
 */
public class ReaderDaoImpl implements ReaderDao {
    @Override
    public boolean update(String readername, String vip, String phone, String credit) {
        //获取数据库连接
        MongoDatabase mongoDatabase = JDBCUtils.getComMongodb();
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("reader");

        //调用更新方法,更新读者记录

        //获取更新的关键字(要知道是更新哪条记录,否则会全部更新)
        Bson filter = Filters.eq("读者姓名",readername);

        //Document封装更新的内容
        Document document = new Document("$set",new Document("读者姓名",readername).append("是否为vip",vip).append("联系方式",phone).append("信誉",credit));

        //updateOne()方法 前一个参数是更新的条件,第二个参数是更新的内容
        mongoCollection.updateOne(filter,document);

        //更新的结果
        return true;
    }

    @Override
    public Reader selectBybookname(String readername) {
        //连接数据库
        MongoDatabase mongoDatabase = JDBCUtils.getComMongodb();
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("reader");

        //根据形参进行查询
        BasicDBObject filter_dbobject = new BasicDBObject();
        filter_dbobject.put("读者姓名",readername);
        FindIterable<Document> findIterable = mongoCollection.find(filter_dbobject);
        MongoCursor<Document> mongoCursor = findIterable.iterator();

        //将查询到的记录保存到pojo对象中
        Reader reader = new Reader();
        while (mongoCursor.hasNext()){
            Document document = mongoCursor.next();

            //赋值
            reader.setReadername(document.getString("读者姓名"));
            reader.setVip(document.getString("是否为vip"));
            reader.setPhone(document.getString("联系方式"));
            reader.setCredit(document.getString("信誉"));
        }

        return reader;
    }

    //查找全部读者信息
    @Override
    public List find() {
        //连接数据库
        MongoDatabase mongoDatabase = JDBCUtils.getComMongodb();

        //获取reader表中的数据
        //访问的表reader
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("reader");

        //调用find()进行查询reader表中的全部数据,获取迭代器
        FindIterable<Document> findIterable = mongoCollection.find();

        //将迭代出来的内容放入游标挨个遍历
        MongoCursor mongoCursor = findIterable.iterator();

        //创建存放读者的数组
        List<Reader> list = new ArrayList<>();

        //循环数据,将数据复制给对应的Reader对象
        while (mongoCursor.hasNext()){
            Reader reader = new Reader();
            Document document = (Document) mongoCursor.next();

            //复制
            reader.setReadername(document.getString("读者姓名"));
            reader.setVip(document.getString("是否为vip"));
            reader.setPhone(document.getString("联系方式"));
            reader.setCredit(document.getString("信誉"));

            //将Reader对象存入list中
            list.add(reader);
        }

        return list;
    }

    //插入读者信息
    @Override
    public void insert(String readername, String vip, String phone, String credit) {
        MongoDatabase mongoDatabase;
        MongoCollection<Document> mongoCollection;
        Document document;

        //获取数据库的连接
        mongoDatabase = JDBCUtils.getComMongodb();
        mongoCollection = mongoDatabase.getCollection("reader");

        //建立插入数据
        document = new Document("读者姓名",readername).append("是否为vip",vip).append("联系方式",phone).append("信誉",credit);

        List<Document> documents = new ArrayList<>();
        documents.add(document);
        mongoCollection.insertMany(documents);
    }
}




















