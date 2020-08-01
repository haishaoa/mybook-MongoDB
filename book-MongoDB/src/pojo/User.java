package pojo;

/**
 * @author haishao
 * @create 2020-05-12 19:48
 * @discript :
 * 用户对象--1.用于接收来自注册页面和
 *          2.数据库中的用户表中的对象
 */
public class User {
    private String username;
    private String id;
    private String password;

    public User() {
    }

    public User(String username, String id, String password) {
        this.username = username;
        this.id = id;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
