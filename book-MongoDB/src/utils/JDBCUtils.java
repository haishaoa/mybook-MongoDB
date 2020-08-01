package utils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * @author haishao
 * @create 2020-05-18 14:55
 * @discript :
 */
public class JDBCUtils {
    //获取数据库连接book库
    public static MongoDatabase getComMongodb(){
        MongoClient mongoClient;
        MongoDatabase mongoDatabase;
        mongoClient = new MongoClient("localhost",27017);
        mongoDatabase = mongoClient.getDatabase("book");
        return mongoDatabase;
    }
}
