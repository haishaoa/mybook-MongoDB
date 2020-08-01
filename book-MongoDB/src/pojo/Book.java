package pojo;

/**
 * @author haishao
 * @create 2020-05-18 15:40
 * @discript :
 */
public class Book {
    private int createOrderNum;
    private String bookname;
    private String booktype;
    private int booksalary;
    private int bookstock;
    private String vip;
    private String time;

    public Book() {
    }

    public Book(int createOrderNum, String bookname, String booktype, int booksalary, int bookstock, String vip, String time) {
        this.createOrderNum = createOrderNum;
        this.bookname = bookname;
        this.booktype = booktype;
        this.booksalary = booksalary;
        this.bookstock = bookstock;
        this.vip = vip;
        this.time = time;
    }

    public int getCreateOrderNum() {
        return createOrderNum;
    }

    public void setCreateOrderNum(int createOrderNum) {
        this.createOrderNum = createOrderNum;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public int getBooksalary() {
        return booksalary;
    }

    public void setBooksalary(int booksalary) {
        this.booksalary = booksalary;
    }

    public int getBookstock() {
        return bookstock;
    }

    public void setBookstock(int bookstock) {
        this.bookstock = bookstock;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Book{" +
                "createOrderNum='" + createOrderNum + '\'' +
                ", bookname='" + bookname + '\'' +
                ", booktype='" + booktype + '\'' +
                ", booksalary=" + booksalary +
                ", bookstock=" + bookstock +
                ", vip='" + vip + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
